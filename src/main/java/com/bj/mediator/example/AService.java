package com.bj.mediator.example;

import lombok.Data;

@Data
public class AService {
    private String message;
    public void doSomeThing(){
        System.out.println("A服务做了一些事情！");
    }
}
