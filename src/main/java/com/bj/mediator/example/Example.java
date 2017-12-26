package com.bj.mediator.example;

import com.bj.mediator.transfer.ATransfer;
import com.bj.mediator.transfer.Btransfer;

public class Example {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        mediator.setaService(new AService());
        mediator.setbService(new BService());
        ATransfer aTransfer = new ATransfer();
        Btransfer btransfer = new Btransfer();
        aTransfer.setMediator(mediator);
        btransfer.setMediator(mediator);
        aTransfer.testA();
        btransfer.test();
    }
}
