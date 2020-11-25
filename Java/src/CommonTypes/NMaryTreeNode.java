package CommonTypes;

import java.util.List;

public class NMaryTreeNode {
    public int val;
    public List<NMaryTreeNode> children;

    public NMaryTreeNode() {}

    public NMaryTreeNode(int _val,List<NMaryTreeNode> _children) {
        val = _val;
        children = _children;
    }
};
