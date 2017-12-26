package com.bj.contract.impl;

import com.bj.contract.Icommand;
import com.bj.recivier.TestReceiver;

public class PlayCommand implements Icommand{
    private TestReceiver testReceiver;

    public PlayCommand(TestReceiver testReceiver) {
        this.testReceiver = testReceiver;
    }

    @Override
    public void excute() {
        testReceiver.play();
    }

    @Override
    public void undo() {
        testReceiver.pause();
    }
}
