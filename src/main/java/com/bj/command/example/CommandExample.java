package com.bj.command.example;

import com.bj.command.Invoker.TvInvoker;
import com.bj.command.recivier.TestReceiver;

public class CommandExample {
    public static void main(String[] args) {
        TestReceiver testReceiver = new TestReceiver();
        TvInvoker tvInvoker = new TvInvoker();
        tvInvoker.init();
//        tvInvoker.excute();
        tvInvoker.excuteTCommadn("play");

    }
}
