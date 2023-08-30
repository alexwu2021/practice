package com.practice.Medium;


import com.practice.DataStructure.CommonTypes.ListNode;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class SortSinglyList {

    public ListNode sortList_bruteForce(ListNode head) {
        if(head == null || head.next == null) return head;

        boolean changed;
        do{
            changed = false;
            ListNode curr = head;
            while(curr.next != null){
                if(curr.val > curr.next.val){
                    int temp = curr.next.val;
                    curr.next.val = curr.val;
                    curr.val = temp;
                    changed = true;
                }
                curr = curr.next;
            }
        }while(changed);
        return head;
    }


    /** this is not a constance space solution but it is a very practical one
     *  main algo from jeantimex
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode runner = dummy;

        // move node ahead on one of the two lists at each loop
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                runner.next = l1;
                l1 = l1.next;
            }else{
                runner.next = l2;
                l2 = l2.next;
            }
            runner = runner.next;
        }
        if(l1 != null) runner.next = l1;
        if(l2 != null) runner.next = l2;

        return dummy.next;
    }
}
