package com.entity;

import lombok.Data;
import lombok.extern.java.Log;

import java.util.List;

@Data
@Log
public class Student {
    private int age;
     private List<Integer> ar;
}
