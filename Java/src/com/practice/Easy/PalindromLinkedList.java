package com.practice.Easy;


import com.practice.DataStructure.CommonTypes.ListNode;

public class PalindromLinkedList {

    /**
     * Given a singly linked list, determine if it is a palindrome.
     *
     * Example 1:
     *
     * Input: 1->2
     * Output: false
     * Example 2:
     *
     * Input: 1->2->2->1
     * Output: true
     * Follow up:
     * Could you do it in O(n) time and O(1) space?
     *
     * yes but we have to overwrite the list, although we can reverse its back, starting from where
     * the slow pointer points to to the end.
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null) return true;

        // pin down the midway pointer which is "slow"
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // adjustment for oddness
        if (fast != null) { // that means fast.next == null
            slow = slow.next;
        }

        slow = reverse(slow);

        fast = head;
        while (slow != null && fast != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode newHead = null;

        while (head != null) { // loop on the nodes not their nexts
            ListNode next = head.next;

            head.next = newHead;
            newHead = head;

            head = next; // stop writing head = head.next
        }
        return newHead;
    }


}
