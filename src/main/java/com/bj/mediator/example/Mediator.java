package com.bj.mediator.example;

import lombok.Data;

@Data
public class Mediator {
    private BService bService;
    private AService aService;

    public void setbService(BService bService) {
        this.bService = bService;
    }

    public void setaService(AService aService) {
        this.aService = aService;
    }

    public void doSomeThing(){
        System.out.println("Mediator.doSomeThing");
        aService.doSomeThing();
    }
    public void doSomeThingB(){
        System.out.println("Mediator.doSomeThingB");
        bService.doSomeThingB();
    }
}
