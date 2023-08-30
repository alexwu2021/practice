package com.practice.Easy;

import CommonTypes.ListNode;

public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;

        int i = k;
        ListNode grpTail = head;
        while(i >= 0){
            grpTail = grpTail.next;
            if (grpTail == null)
                return head;
            i--;
        }

        ListNode remaining = grpTail.next;
        grpTail.next = null;

        ListNode new_head = reverse(head);

        // after reversal, head is actuall the new tail of the first k group
        head.next = reverseKGroup(remaining, k);
        return new_head;
    }

    public ListNode reverse(ListNode head) {
        ListNode current_head = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = current_head;
            current_head = head;
            head = next;
        }
        return current_head;
    }
}
