package com.bj.responsibility.example;

public class Test {
    public static void main(String[] args) {
        BlackFilter blackFilter = new BlackFilter();
        SentiveFilter sentiveFilter = new SentiveFilter();
        InsertFilter insertFilter= new InsertFilter();

        sentiveFilter.setNextHandler(insertFilter);
        blackFilter.setNextHandler(sentiveFilter);
        insertFilter.setNextHandler(null);
        //从这一行往上都可以在初始化的时候做好这些工作，然后通过提供一个可以来调用，就是初始化一个过滤连然后就可以到处调用了！
        Request request = new Request();
        request.setName("abc");
        blackFilter.handle(request,null);
    }
}
