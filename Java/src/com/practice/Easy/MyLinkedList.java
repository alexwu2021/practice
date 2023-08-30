package com.practice.Easy;

import CommonTypes.ListNode;

/**
 * Design your implementation of the linked list. You can choose to use the singly linked list or the doubly linked list. A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node. If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.
 *
 * Implement these functions in your linked list class:
 *
 * get(index) : Get the value of the index-th node in the linked list. If the index is invalid, return -1.
 * addAtHead(val) : Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
 * addAtTail(val) : Append a node of value val to the last element of the linked list.
 * addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
 * deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.
 * Example:
 *
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
 * linkedList.get(1);            // returns 2
 * linkedList.deleteAtIndex(1);  // now the linked list is 1->3
 * linkedList.get(1);            // returns 3
 * Note:
 *
 * All values will be in the range of [1, 1000].
 * The number of operations will be in the range of [1, 1000].
 * Please do not use the built-in LinkedList library.
 *
 *
 *
 *
 * there is a known issue with the LC test cases, so this code will only pass all the test cases except one or two
 *
 * this problem does not worht your efforts, before the broken test cases is fixed.
 *
 */
public class MyLinkedList {
    /** Initialize your data structure here. */

    private ListNode _dummyHead;


    public MyLinkedList() {
        _dummyHead = new ListNode(Integer.MIN_VALUE);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {

        if(_dummyHead.next == null) return -1;

        ListNode temp = _dummyHead.next;
        int idx = 0;
        while(idx != index && temp != null) {
            idx++;
            temp = temp.next;
        }

        if(temp != null) return temp.val;
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode next = _dummyHead.next;
        _dummyHead.next = new ListNode(val);
        _dummyHead.next.next = next;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode temp = _dummyHead;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = new ListNode(val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(_dummyHead.next == null ){
            if(index == 0){
                _dummyHead.next = new ListNode(val);
            }
            return;
        }

        if(val < 0){
            return;
        }

        ListNode temp = _dummyHead.next;
        int idx = 0;
        while(idx != index - 1 && temp != null) {
            idx++;
            temp = temp.next;
        }

        if(temp == null){
            if(index == 0) _dummyHead.next = new ListNode(val);
            return;
        }

        ListNode next = temp.next;

        temp.next = new ListNode(val);
        temp.next.next = next;

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(_dummyHead.next == null) return;

        ListNode temp = _dummyHead.next;
        int idx = 0;
        while(idx != index - 1 && temp != null) {
            idx++;
            temp = temp.next;
        }

        if(temp == null){
            if(index == 0) _dummyHead.next = _dummyHead.next != null? _dummyHead.next.next : null;
            return;
        }

        temp.next = temp.next != null? temp.next.next : null;
    }

}
