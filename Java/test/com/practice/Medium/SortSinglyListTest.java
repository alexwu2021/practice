package com.practice.Medium;

import CommonTypes.ListNode;
import org.junit.Test;

public class SortSinglyListTest {

    @Test
    public void sortList() {
        SortSinglyList sortSinglyList = new SortSinglyList();
        ListNode head, res;

//        head = new ListNode(4);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(1);
//        head.next.next.next = new ListNode(3);
//        res = sortSinglyList.sortList(head);
//        assert(res.val == 1 && res.next.val == 2 && res.next.next.val ==3 && res.next.next.next.val == 4);

        head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        res = sortSinglyList.sortList(head);
        assert(res.val == -1 && res.next.val == 0 && res.next.next.val ==3
                && res.next.next.next.val == 4 && res.next.next.next.next.val == 5);
    }
}