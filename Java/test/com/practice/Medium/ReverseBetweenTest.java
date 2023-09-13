package com.practice.Medium;

import com.practice.DataStructure.CommonTypes.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseBetweenTest {

    ReverseBetween sol = new ReverseBetween();
    @Test
    void reverseBetween() {

        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        int left = 1, right = 2;

        ListNode actual;

        actual = sol.reverseBetween(head, left, right);
        assertNotNull(actual);



    }
}