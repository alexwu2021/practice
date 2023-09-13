package com.practice.Medium;

import com.practice.DataStructure.CommonTypes.ListNode;

public class ReverseBetween {

//    public ListNode reverseBetween(ListNode head, int left, int right) {
//        ListNode dummy = new ListNode(0); // created dummy node
//        dummy.next = head;
//        ListNode prev = dummy; // intialising prev pointer on dummy node
//
//        for(int i = 0; i < left - 1; i++)
//            prev = prev.next; // adjusting the prev pointer on it's actual index
//
//        ListNode curr = prev.next; // curr pointer will be just after prev
//        // reversing
//        for(int i = 0; i < right - left; i++){
//            ListNode forw = curr.next; // forw pointer will be after curr
//            curr.next = forw.next;
//            forw.next = prev.next;
//            prev.next = forw;
//        }
//        return dummy.next;
//    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prevLeft = head;
        int i = 0;
        for(; i < left - 1; ++i)
            prevLeft = prevLeft.next;

        ListNode ptrRight = prevLeft;
        for(; i < right; ++i)
            ptrRight = ptrRight.next;

        ListNode postRight = ptrRight.next;
        ptrRight.next = null;
        prevLeft.next = reverse(prevLeft.next);


        ListNode tail = prevLeft.next;
        while(tail != null){
            tail = tail.next;
        }

        tail.next = postRight;
        return head;
    }

    private ListNode reverse(ListNode head){
        ListNode newHead = null, next;
        while(head != null){
            next = head.next;

            head.next = newHead;
            newHead = head;

            head = next;
        }
        return newHead;
    }
}
