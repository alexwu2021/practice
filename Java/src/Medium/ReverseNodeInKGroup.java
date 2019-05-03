package Medium;

import CommonTypes.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a
 * multiple of k then left-out nodes in the end should remain as it is.
 */
public class ReverseNodeInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return head;

        // find the first k group and isolate it from the rest
        ListNode tempHead = head, trailer = null;
        int count = 0;
        while(head != null && count < k){
            trailer = head;
            head = head.next;
            count++;
        }
        if(head == null && count < k) return tempHead;
        trailer.next = null; // de-tail

        // do a normal reverse of list
        ListNode ret = reverseList(tempHead);

        // tempHead becomes the tale to which we can append the rest
        tempHead.next = reverseKGroup(head, k);

        return ret;
    }


    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode second = head.next;
        head.next = null; // the same idea as above: de-tail

        ListNode rest = reverseList(second);
        second.next = head;
        return rest;
    }
}
