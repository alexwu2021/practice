package Medium;

import CommonTypes.ListNode;
import org.junit.Test;

import static CommonTypes.ListNode.compareTwoLists;
import static CommonTypes.ListNode.toNodeList;
import static org.junit.Assert.*;

public class ReverseNodeInKGroupTest {

    @Test
    public void reverseKGroup() {
        ReverseNodeInKGroup reverseNodeInKGroup = new ReverseNodeInKGroup();
        ListNode head, actual, expected;
        int [] inputs;
        int k;


        inputs = new int [] {1, 2, 3, 4, 5};
        k = 2;
        head = toNodeList(inputs);
        expected = toNodeList(new int [] {2, 1, 4, 3, 5});
        actual = reverseNodeInKGroup.reverseKGroup(head, k);
        assertTrue(compareTwoLists(actual, expected));


        k = 3;
        head = toNodeList(inputs);
        expected = toNodeList(new int [] {3, 2, 1, 4, 5});
        actual = reverseNodeInKGroup.reverseKGroup(head, k);
        assertTrue(compareTwoLists(actual, expected));



        k = 2;
        inputs = new int []{1, 2};
        head = toNodeList(inputs);
        expected = toNodeList(new int [] {2, 1 });
        actual = reverseNodeInKGroup.reverseKGroup(head, k);
        assertTrue(compareTwoLists(actual, expected));


    }





}