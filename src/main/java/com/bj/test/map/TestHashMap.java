package com.bj.test.map;

import com.bj.test.model.Skey;

import java.util.HashMap;
import java.util.Random;

public class TestHashMap {
    public static void main(String[] args) {
        HashMap<Skey, Object> hashMap = new HashMap<Skey, Object>();
        for (int i = 0; i < 100; i++) {
            Skey skey = new Skey();
            skey.setName("String" + new Random(10).nextInt());
            hashMap.put(skey, new Object());
        }
        System.out.println("hashMap.size() = " + hashMap.size());
    }
}
