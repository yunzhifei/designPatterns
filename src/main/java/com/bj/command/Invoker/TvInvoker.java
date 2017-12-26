package com.bj.command.Invoker;

import com.bj.command.contract.Icommand;
import com.bj.command.contract.enums.CommandCache;

import java.util.HashMap;
import java.util.Map;

public class TvInvoker {
    private Map<String,Icommand> commandMap = new HashMap<>();
    private CommandCache commandEnum;
    //初始化,b把所有而已执行的命令都缓存一遍，客户端只需要根据命令的key来执行命令就可以了
    public void  init(){
        commandEnum=new CommandCache();
        commandEnum.init();
        for(Object key : commandEnum.getCommandHashMap().keySet()){
            commandMap.put(String.valueOf(key), (Icommand) commandEnum.getCommandHashMap().get(key));
        }
    }


    public Icommand removeCommand(String key){
        return commandMap.remove(key);
    }

    public void excute(){
        for(String string : commandMap.keySet()){
            commandMap.get(string).excute();
        }
    }
    public void excuteTCommadn(String key){
        commandMap.get(key).excute();
    }
    public void undo(){
        System.out.println("\"undo\" = " + "undo");
    }
}
