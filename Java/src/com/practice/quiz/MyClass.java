package com.practice.quiz;

import java.util.HashMap;
import java.util.Map;

public class MyClass {
    private Map<String, Integer> map;
    public int callCount;

    public MyClass() {
        map = new HashMap<>();
        map.put("foo", 1);
        map.put("bar", 3);
    }

    public int getValue(String input, int numRetries) throws Exception {
        callCount++;
        try {
            return map.get(input);
        }
        catch (Exception e) {
            if (numRetries > 3) {
                throw e;
            }
            return getValue(input, numRetries + 1);
        }
    }

    public static void main(String[] args){
        MyClass myClass = new MyClass();
        try {
//            myClass.getValue("foo", 0);
//            myClass.getValue("bar", 2);
//            myClass.getValue("baz", 0);
            myClass.getValue("fubar", 1);
        } catch (Exception e) {
        }

        int callCount = myClass.callCount;
        System.out.println("call count: " + callCount);
    }
}

