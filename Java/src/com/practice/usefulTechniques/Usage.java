package com.practice.usefulTechniques;

import java.util.ArrayList;
import java.util.List;

public class Usage {

    public  static void main(String[] args){


        List<Integer> list = new ArrayList<>(0);
        int[] arr = list.stream().mapToInt(i -> i).toArray();

    }
}
