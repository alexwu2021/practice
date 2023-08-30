package com.practice.Hard;

import CommonTypes.ListNode;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {

    private ListNode mergeTwoSortedLists(ListNode a, ListNode b){
        if(a == null) return b;
        if(b == null) return a;

        ListNode dummy = new ListNode(0), runner;

        // initialization
        // be conservative, never premove the runner
        // in other word, runner.next is a dangerous place, try not to move to its next
        // unless runner.next has been placed solidly on a valid node
        if(a.val <= b.val){
            runner = a;
            a = a.next;
        } else {
            runner = b;
            b = b.next;
        }
        dummy.next = runner;

        // the run part
        while(a != null && b != null){
            if(a.val <= b.val){
                runner.next = a;
                a = a.next;
            } else {
                runner.next = b;
                b = b.next;
            }
            runner = runner.next;
        }

        // the wrapp-up part, be careful, it is runner.next not runner
        if(a != null) runner.next = a;
        if(b != null) runner.next = b;

        return dummy.next;
    }

    /** OJ passed
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length <= 0) return null;
        if(lists.length == 1) return lists[0];
        if(lists.length == 2) return mergeTwoSortedLists(lists[0], lists[1]);

        int n = lists.length, mid = lists.length >> 1;
        ListNode[] left = new ListNode[mid + 1];
        ListNode[] right = new ListNode[n - mid];

        for(int i = 0; i <= mid; ++i) left[i] = lists[i];
        for(int j = mid + 1, k = 0; j < n; ++j) right[k++] = lists[j];

        ListNode lres = mergeKLists(left);
        ListNode rres = mergeKLists(right);

        return mergeTwoSortedLists(lres, rres);
    }


}
