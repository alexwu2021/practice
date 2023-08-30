package com.practice.Easy;

import CommonTypes.ListNode;
import org.junit.Test;

public class MyLinkedListTest {

    @Test
    public void get() {

        MyLinkedList myLinkedList = new MyLinkedList();
        int result;
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.get(1);
        myLinkedList.deleteAtIndex(0);
        result = myLinkedList.get(0);
        assert(result == 2);

        myLinkedList = new MyLinkedList();
        myLinkedList.addAtIndex(-1, 0);
        result = myLinkedList.get(0);
        assert(result == 0);
        myLinkedList.deleteAtIndex(-1);

        myLinkedList = new MyLinkedList();
        assert(myLinkedList.get(0) == -1);

        myLinkedList.addAtIndex(1, 2);
        result = myLinkedList.get(0);
        assert(result == -1);
        result = myLinkedList.get(0);
        assert(result == -1);

        myLinkedList.addAtIndex(0, 1);

        result = myLinkedList.get(0);
        assert(result == -1);
        result = myLinkedList.get(0);
        assert(result == -1);

    }
}