package com.bj.contract.enums;

import com.bj.contract.Icommand;
import com.bj.contract.impl.PlayCommand;
import com.bj.recivier.TestReceiver;
import lombok.Data;

import java.util.HashMap;
@Data
public class CommandCache<T extends Icommand> {
    private HashMap<String,T> commandHashMap = new HashMap<String,T>();
    public void init(){
        commandHashMap.put("play", (T) new PlayCommand(new TestReceiver()));
    }
}
