package com.bj.mediator.example;

import lombok.Data;

@Data
public class BService {
    private String message;
    public void doSomeThingB(){
        System.out.println("B服务做了一些事情！");
    }
}
