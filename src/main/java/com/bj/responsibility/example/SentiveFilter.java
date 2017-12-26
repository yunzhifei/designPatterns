package com.bj.responsibility.example;

import com.bj.responsibility.simple.TestFilter;

public class SentiveFilter extends TestFilter {
    @Override
    public void handle(Object target, Object other) {
        if(target instanceof Request){
            Request request = (Request) target;
            if(request.getName().equals("senstive")){
                System.out.println("敏感不能发消息！");
                if(null == getNextHandler()){
                    System.out.println("处理完毕!");
                }
                stop();
            }else {
                System.out.println("不敏感！");
                if(null == getNextHandler()){
                    System.out.println("处理完毕!");
                }else {
                    getNextHandler().handle(target, other);
                }
            }
        }
    }
}
