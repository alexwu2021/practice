package com.practice.Easy;

import com.practice.DataStructure.CommonTypes.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromLinkedListTest {

    PalindromLinkedList palindromLinkedList = new PalindromLinkedList();
    @Test
    void isPalindrome() {
    }

    @Test
    void reverse() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode actual;
        actual = palindromLinkedList.reverse(head);
        assertNotNull(actual);
        assertTrue(actual.val == 3);

        assertNotNull(actual.next);
        assertTrue(actual.next.val == 2);

        assertNotNull(actual.next.next);
        assertTrue(actual.next.next.val == 1);
    }
}