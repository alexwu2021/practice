package com.practice.util;

import java.util.*;

public class syntatic {
    class User implements Comparable<User> {
        public String name;
        public int age;

        public User(String name, int age)
        {
            this.name = name;
            this.age = age;
        }

        public int compareTo(User u1)
        {
            return name.compareTo(u1.name);
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public int getAge()
        {
            return age;
        }

        public void setAge(int age)
        {
            this.age = age;
        }
    }

    void compare(){
        int[][] intervals = new int[10][20];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        List<int[]> intervals2 = new ArrayList<>();
        Collections.sort(intervals2, (a, b) -> b[1] - a[1]);


        List<User> list = new ArrayList<>();
        Collections.sort(list, Comparator.comparingInt(User::getAge));  // Comparator<User>
        Collections.sort(list, Comparator.comparingInt(User::getAge).reversed());

    }

}
