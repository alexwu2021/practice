package com.practice.Medium;


import com.practice.DataStructure.CommonTypes.ListNode;

public class InsertionSortLinkedList {
    /** Should be working as recorded from leetcode app
     *
     * @param node
     * @return
     */
    ListNode insertionSortedList(ListNode node){
        if(node == null) return node;

        ListNode pre, curr, next, helper = new ListNode(0);
        curr = node;
        pre = helper; //need to assign to helper.next;
        while(curr != null){
            next = curr.next;
            while(pre.next != null && pre.next.val < curr.val) {
                pre = pre.next;
            }
            curr.next = pre.next;
            pre.next = curr;

            pre = helper;
            curr = next;
        }
        return helper.next;
    }
}
