package com.practice.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PrintNmaryTree {
    /**
     * an m-ary tree node
     * declared as static, due to fasterxml json deserializer's requirement
     */
    static class Node {
        public String id;
        public List<String> childIds;
        public Node(){
            this.childIds = new ArrayList<>();
        }
    }

    private static String ROOT_NODE_ID = "RootId";

    private void dfs(String nodeId, int level, Map<String, List<String>> mp) {
        for (int i = 0; i < level; ++i) System.out.print("--");
        System.out.println(nodeId);

        List<String> children = mp.get(nodeId);
        if (children == null) return;
        for (String cid : children) dfs(cid, level + 1, mp);
    }

    public void parseAndPrintAllNodes(String input) throws JsonProcessingException {
        // parser logic
        ObjectMapper mapper = new ObjectMapper();
        List<Node>nodes = mapper.readValue(input,  new TypeReference<List<Node>>(){} );
        String rootNodeId = null;
        Map<String, List<String>>mp = new HashMap<>();
        for(Node n : nodes) {
            if(n.id.equals(ROOT_NODE_ID)) {
                rootNodeId = n.id;
            }
            if(n.childIds.size() <= 0){
                mp.computeIfAbsent(n.id, x->new ArrayList<>());
                continue;
            }
            for(String childId : n.childIds) {
                mp.computeIfAbsent(n.id, x -> new ArrayList<>()).add(childId);
            }
        }

        // the printing logic
        dfs(rootNodeId, 0, mp);
    }

    public static  void main(String[] args)  {
        String input = "[" +
                " { \"id\": \"RootId\",\"childIds\": [ \"ChildId1\", \"ChildId2\", \"ChildId3\" ] }, " +
                " { \"id\": \"ChildId1\", \"childIds\": [ ] } ," +
                " { \"id\": \"ChildId2\", \"childIds\": [ \"GrandchildId1\", \"GrandchildId2\" ] } " +
                "]";
        PrintNmaryTree sol = new PrintNmaryTree();
        try{
            sol.parseAndPrintAllNodes(input);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}