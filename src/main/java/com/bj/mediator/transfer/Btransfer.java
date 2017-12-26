package com.bj.mediator.transfer;

import com.bj.mediator.example.Mediator;
import lombok.Data;

@Data
public class Btransfer {
    private Mediator mediator;

    public void test(){
        mediator.doSomeThing();
        mediator.doSomeThingB();
    }
}
