package com.bj.example;

import com.bj.Invoker.TvInvoker;
import com.bj.recivier.TestReceiver;

public class CommandExample {
    public static void main(String[] args) {
        TestReceiver testReceiver = new TestReceiver();
        TvInvoker tvInvoker = new TvInvoker();
        tvInvoker.init();
//        tvInvoker.excute();
        tvInvoker.excuteTCommadn("play");

    }
}
