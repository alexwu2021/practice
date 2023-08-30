package com.practice.Medium;

import CommonTypes.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents {

    public int numComponents(ListNode head, int[] G) {
        Set<Integer> st = new HashSet<>();
        for(int g: G)  st.add(g);

        int res = 0;
        ListNode temp = head;
        while(temp != null){
            if(st.contains(temp.val) // this is the key part i missed even after borrowing this algo
                    && (temp.next == null || !st.contains(temp.next.val)))
                res++;
            temp = temp.next;
        }
        return res;
    }

    /*
    public int numComponentsEasySpeaks(ListNode head, int[] G) {
        Set<Integer> st = new HashSet<>();
        for(int g: G)  st.add(g);

        int res = 0;
        ListNode temp = head;
        while(temp != null){
            if(st.contains(temp.val)) // this is the key part i missed even after borrowing this algo
            {
                // the last element in the list
                if(temp.next == null){
                    res++;
                }

                // temp is at the end of the path
                else if(!st.contains(temp.next.val)){
                    res++;
                }
            }
            temp = temp.next;
        }
        return res;
    }
    */
}
