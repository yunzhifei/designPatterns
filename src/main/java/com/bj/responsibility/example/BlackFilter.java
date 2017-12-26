package com.bj.responsibility.example;

import com.bj.responsibility.simple.TestFilter;

public class BlackFilter extends TestFilter{
    @Override
    public void handle(Object target, Object other) {
        if(target instanceof Request){
            Request request = (Request) target;
            if(request.getName().equals("black")){
                System.out.println("黑户不能发消息！");
                if(null == getNextHandler()){
                    System.out.println("处理完毕!");
                }
                stop();
            }else {
                System.out.println("不是黑户！");
                if(null == getNextHandler()){
                    System.out.println("处理完毕!");
                }else {
                    getNextHandler().handle(target, other);
                }
            }
        }
    }
}
