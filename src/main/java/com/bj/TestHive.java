package com.bj;

import com.alibaba.fastjson.JSON;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestHive {
    //    private static final Logger logger = LoggerFactory.getLogger(TestHive.class);
    private static final String CLAZZANDMETHODSQL = "SELECT clazz,method ,avg(timecost) as avgTime \n" +
            "FROM hdp_lbg_zhaopin_defaultdb.t_zpjl_jianliagent \n" +
            "where dt=\"%s\" and cluster=\"%s\" \n" +
            " GROUP by clazz,method order BY avgTime desc LIMIT 20";
    private static final String TOPTWOHUNDREDTRACENODE = "SELECT *\n" +
            " FROM hdp_lbg_zhaopin_defaultdb.t_zpjl_jianliagent\n" +
            " where dt=\"%s\" and cluster=\"%s\" and clazz=\"%s\" AND method=\"%s\" order BY timecost desc LIMIT 200";

    static {
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:hive2://10.126.215.131:10000/default", "hdp_lbg_zhaopin", "");
    }

    public static List<ClazzAndMethod> getClazzAndMenthod(String cluster) {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        List<ClazzAndMethod> andMethods = new ArrayList<ClazzAndMethod>();
        try {
            connection = getConnection();
            String sql = String.format(CLAZZANDMETHODSQL, DateUtil.getYesterDay(), cluster);
            System.out.println("sql " + sql);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.execute("set mapreduce.job.queuename=root.offline.hdp_lbg_zhaopin.normal");
            resultSet = statement.executeQuery(sql);
            System.out.println("resultSet = " + resultSet.getFetchSize());
            System.out.println("resultSet = " + resultSet.next());
            System.out.println("resultSet.getString(1) = " + resultSet.getString(1));
            while (resultSet.next()) {
                ClazzAndMethod clazzAndMethod = new ClazzAndMethod();
                clazzAndMethod.setCalzz(resultSet.getString(1));
                clazzAndMethod.setMethod(resultSet.getString(2));
                andMethods.add(clazzAndMethod);
//                System.out.println("resultSet.getString(1) = " + resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeSource(connection, statement, resultSet);
        }
        return andMethods;
    }

    public static void closeSource(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<TraceNode> getTopTwoHundred(String cluster, List<ClazzAndMethod> clazzAndMethodList) {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        List<TraceNode> list = new ArrayList<TraceNode>();
        try {
            connection = getConnection();
//            for (ClazzAndMethod clazzAndMethod : clazzAndMethodList) {
                String sql = String.format(TOPTWOHUNDREDTRACENODE, DateUtil.getYesterDay(), cluster, clazzAndMethodList.get(0).getCalzz(), clazzAndMethodList.get(0).getMethod());
                System.out.println("sql " + sql);
                statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                statement.execute("set mapreduce.job.queuename=root.offline.hdp_lbg_zhaopin.normal");
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    TraceNode traceNode = new TraceNode();
                    traceNode.setUuid(resultSet.getString(1));
                    traceNode.setClazz(resultSet.getString(2));
                    traceNode.setMethod(resultSet.getString(3));
                    traceNode.setStartnano(resultSet.getLong(4));
                    traceNode.setEndnano(resultSet.getLong(5));
                    traceNode.setTimecost(resultSet.getLong((6)));
                    traceNode.setStep(resultSet.getInt(7));
                    traceNode.setSubNodes(JSON.parseArray(resultSet.getString(8), TraceNode.class));
                    traceNode.setDt(resultSet.getString(9));
                    traceNode.setCluster(resultSet.getString(10));
                    System.out.println("JSON.toJSONString(tr\\) = " + JSON.toJSONString(traceNode));
                    list.add(traceNode);
                }
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeSource(connection, statement, resultSet);
        }
        return list;
    }

    public static void main(String[] args) {
        List<ClazzAndMethod> zhaopin_jianli_third = getClazzAndMenthod("zhaopin_jianli_third");
        List<TraceNode> zhaopin_jianli_third1 = getTopTwoHundred("zhaopin_jianli_third", zhaopin_jianli_third);
//        System.out.println("zhaopin_jianli_third1 = " + );
    }
}
