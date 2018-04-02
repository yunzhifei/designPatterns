package com.bj;

import com.bj.visitor.element.TimecostElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestZYS {
    public static void main(String[] args) throws Exception {
        TimecostElement timecostElement = new TimecostElement();
        timecostElement.setTimecost("1,806,121");
        TimecostElement timecostElement1 = new TimecostElement();
        timecostElement1.setTimecost("135,938,542");
        TimecostElement timecostElement2 = new TimecostElement();
        timecostElement2.setTimecost("152,571,444");
        TimecostElement timecostElement3 = new TimecostElement();
        timecostElement3.setTimecost("189,011,755");
        TimecostElement timecostElement4 = new TimecostElement();
        timecostElement4.setTimecost("278,889,689");

        List<TimecostElement> list = new ArrayList<TimecostElement>();
        list.add(timecostElement);
        list.add(timecostElement1);
        list.add(timecostElement2);
        list.add(timecostElement3);
        list.add(timecostElement4);
        Collections.sort(list);
        for (TimecostElement timecostElement5 : list) {
            System.out.println("timecostElement5.getTimecost() = " + timecostElement5.getTimecost());
        }
    }



}
