package com.practice.Medium;

import CommonTypes.ListNode;

public class SwapPairsOfNode {

    /** passed oj
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;


            current.next = swap(first, second);


            current = current.next.next;
        }

        return dummy.next;
    }


    ListNode swap(ListNode a, ListNode b){
        a.next = b.next;
        b.next = a;
        return b;
    }

}
