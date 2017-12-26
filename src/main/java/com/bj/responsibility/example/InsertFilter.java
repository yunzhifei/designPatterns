package com.bj.responsibility.example;

import com.bj.responsibility.simple.TestFilter;

public class InsertFilter extends TestFilter {
    @Override
    public void handle(Object target, Object other) {
        if(target instanceof Request){
            Request request = (Request) target;
            if(request.getName().equals("insert")){
                System.out.println("不能插入消息！");
                if(null == getNextHandler()){
                    System.out.println("处理完毕!");
                }
                stop();
            }else {
                System.out.println("不是插入！");
                if(null == getNextHandler()){
                    System.out.println("处理完毕!");
                }else {
                    getNextHandler().handle(target, other);
                }
            }
        }
    }
}
