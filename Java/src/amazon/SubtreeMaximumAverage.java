package amazon;

import CommonTypes.NMaryTreeNode;
import sun.awt.image.ImageWatched;

import java.util.*;

public class SubtreeMaximumAverage {
    private int maxHeight = -1;
    private float maxScore = 0;
    private NMaryTreeNode pinned = null;
    private NMaryTreeNode maxNode;

    public NMaryTreeNode findMaximumAverage(NMaryTreeNode node)
    {
        // each node is mapped to [number of children + 1, total vals in the subtree]
        Map<NMaryTreeNode, int[]> nodeToVals = new HashMap<>();
        Map<NMaryTreeNode, NMaryTreeNode> childToParent = new HashMap<>();
        Stack<NMaryTreeNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
          NMaryTreeNode temp =  stack.pop();
          nodeToVals.put(temp, new int[]{1, node.val});
          if(temp.children != null){
              for(NMaryTreeNode c : temp.children){
                  stack.push(c);
                  childToParent.put(c, temp);
              }
          }
        }

        // instantiate an height to layer map
        HashMap<Integer, List<NMaryTreeNode>> heightToNodes = new HashMap<>();
        dfs(node, 0, heightToNodes);


        // take care of the lowest layer first
        for(NMaryTreeNode nd: heightToNodes.get(this.maxHeight -1)){
            nodeToVals.computeIfAbsent(nd, x-> new int[]{1, nd.val});
        }

        for(int i = this.maxHeight-1; i>=0; --i){
            for(NMaryTreeNode nd: heightToNodes.get(i)){
                if(childToParent.containsKey(nd)){
                    NMaryTreeNode x = childToParent.get(nd);

                    if(nodeToVals.containsKey(x)){
                        nodeToVals.put(x, new int []{
                                nodeToVals.getOrDefault(x, new int []{0, 0})[0] +1,
                                nodeToVals.getOrDefault(x, new int []{0, 0})[0] + nd.val,
                        } );
                    }


                    this.maxScore = Math.max(maxScore, ((float)(nodeToVals.get(x)[0])) / nodeToVals.get(x)[1]);
                    this.maxNode = x;
                }
            }
        }

        return this.maxNode;

    }

    private void dfs(NMaryTreeNode node, int height, HashMap<Integer, List<NMaryTreeNode>>layered)
    {
        if(node == null)
            return;

        this.maxHeight = Math.max(height, this.maxHeight);
        if(!layered.containsKey(height)){
            layered.put(height, new ArrayList<>());
        }
        layered.get(height).add(node);

        if(node.children != null){
            for(NMaryTreeNode c : node.children){
                dfs(c, height + 1, layered);
            }
        }
    }
}
