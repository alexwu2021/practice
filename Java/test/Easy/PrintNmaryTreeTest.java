package Easy;

import CommonTypes.NmaryTreeNode2;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintNmaryTreeTest {




    @Test
    public void printAllNodesWrapper2() {
        PrintNmaryTree sol = new PrintNmaryTree();
        NmaryTreeNode2 root = new NmaryTreeNode2();
        root.id = "RootId";
        root.childIds = Arrays.asList("ChildId1", "ChildId2", "ChildId3");
        NmaryTreeNode2 node = new NmaryTreeNode2();
        node.id = "ChildId1";
        root.childIds = new ArrayList<>();
        List<NmaryTreeNode2> lst = new ArrayList<>();
        lst.add(root);
        lst.add(node);
        //com.fasterxml.jackson.core.json.
        //String input = JSON.toJSONString(lst);
        //System.out.println("input: " + input);

        //List<NmaryTreeNode2> lst2 = JSON.parseObject(input, NmaryTreeNode2.class);
    }
}