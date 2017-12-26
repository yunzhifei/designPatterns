package com.bj.mediator.transfer;

import com.bj.mediator.example.Mediator;
import lombok.Data;

@Data
public class ATransfer {
    private Mediator mediator;

    public  void testA(){
        mediator.doSomeThingB();
    }
}
