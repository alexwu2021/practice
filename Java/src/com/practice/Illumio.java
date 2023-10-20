


//cat foo | grep '.com'
//
//
//        ||
//
//        echo bar


//
//
//select u.name from users u
//
//inner join v on u.n = v.n
//
//        (select n, label from data where label like "b%" ) v
//
//;


//        create table users (n int,  name text);
//        create table data (n int,  label text);
//
//        select * from users;
//        n | name
//        ---+------
//        1 | joe
//        2 | bob
//        3 | charlie
//        (3 rows)
//
//        select * from data;
//        n | label
//        ---+-----
//        3 | baz
//        2 | bar
//        1 | foo
//        (3 rows)
//
//        Retrieve all name from users where the corresponding label in data (same n) starts with 'b'
//












//package com.practice;
//
//import java.util.*;
//public class Illumio {
//
//    private Set<String>uniques;
//    private PriorityQueue<String>pq;
//
//
//
//    /**
//     * @param input : big
//     *
//     * @return
//     */
//    public List<List<String>> get2(String input, int offset){
//
//        List<List<String>>res = new ArrayList<>();
//
//        Map<String, Integer>mp = new HashMap<>();
//
//
////        set  -- unique element
//
//        int mx = Integer.MIN_VALUE;
//
//        for(String s: input.split(" ")){
//            mp.put(s, mp.getOrDefault(s, 0) + 1);
//            mx = Math.max(mx, mp.get(s));
//        }
//
//        List<String>topLine = new ArrayList<>();
//        List<String>bottomLine = new ArrayList<>();
//
//        boolean flag = true;
//        for(Map.Entry<String, Integer>entry: mp.entrySet()){
//            topLine.add(entry.getKey());
//            if (flag && entry.getValue() == mx){
//                bottomLine.add(entry.getKey());
//                flag = false;
//            }
//        }
//        res.add(topLine);
//        res.add(bottomLine);
//        return res;
//    }
//
//
//
//
//    public List<List<String>> get(String input){
//
//        List<List<String>>res = new ArrayList<>();
//
//        Map<String, Integer>mp = new HashMap<>();
//        int mx = Integer.MIN_VALUE;
//
//        for(String s: input.split(" ")){
//            mp.put(s, mp.getOrDefault(s, 0) + 1);
//            mx = Math.max(mx, mp.get(s));
//        }
//
//        List<String>topLine = new ArrayList<>();
//        List<String>bottomLine = new ArrayList<>();
//
//        boolean flag = true;
//        for(Map.Entry<String, Integer>entry: mp.entrySet()){
//            topLine.add(entry.getKey());
//            if (flag && entry.getValue() == mx){
//                bottomLine.add(entry.getKey());
//                flag = false;
//            }
//        }
//        res.add(topLine);
//        res.add(bottomLine);
//        return res;
//    }
//
//    public static void main(String[] args){
//
//        String sample1 =  "i am here here am";
////        --> ["i", "am", "here"], ["here"]
////
//        List<List<String>>actual = new Illumio().get(sample1);
//        System.out.println("top line: ") ;//  + " ".join(actual.get(0)));
//    }
//}
