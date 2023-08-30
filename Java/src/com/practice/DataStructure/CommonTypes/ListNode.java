package com.practice.DataStructure.CommonTypes;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public static ListNode toNodeList(int[] input){
        ListNode runner = new ListNode(input[0]);
        ListNode ret = runner;
        for(int i = 1; i < input.length; ++i){
            runner.next = new ListNode(input[i]);
            runner = runner.next;
        }
        return ret;
    }

    public static boolean compareTwoLists(ListNode a, ListNode b){
       while(a != null && b != null){
           if(a.val != b.val) return false;
           a = a.next;
           b = b.next;
       }
       if((a != null) || ( b != null)) return false;
       return true;
    }
 }