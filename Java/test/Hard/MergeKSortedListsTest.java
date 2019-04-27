package Hard;

import CommonTypes.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class MergeKSortedListsTest {

    private final String arrow = "->";
    private String ListNodeToString(ListNode node){
        StringBuilder sb = new StringBuilder();
        while(node != null){
            sb.append(node.val).append(arrow);
            node  = node.next;
        }
        return sb.toString();
    }


    @Test
    public void mergeKLists() {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();

        ListNode[] lists;
        ListNode result;
        String actual, expected;

        lists = new ListNode[3];
        ListNode a, b, c;
        a = new ListNode(1);
        a.next = new ListNode(4);
        a.next.next = new ListNode(5);

        b = new ListNode(1);
        b.next = new ListNode(3);
        b.next.next = new ListNode(4);

        c = new ListNode(2);
        c.next = new ListNode(6);

        int i = 0;
        lists[i++ ] = a;
        lists[i++ ] = b;
        lists[i++ ] = c;

        ListNode res = mergeKSortedLists.mergeKLists(lists);
        actual = ListNodeToString(res);
        expected = "1->1->2->3->4->4->5->6->";
        assert(actual != null && actual.equals(expected) );
    }
}