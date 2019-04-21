package Easy;

import java.util.*;

public class AccountMerge {

    /** borrowed from adaZhang, passed oj for bfs and dfs
     * @param accounts
     * @return
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // build the graph
        Map<String, Set<String>> graph = new HashMap<>();
        for(List<String> accn : accounts){
            for(int i = 1; i< accn.size(); ++i){
                if(!graph.containsKey(accn.get(i))) graph.put(accn.get(i),new HashSet<>());
                graph.get(accn.get(i)).add(accn.get(1));
                graph.get(accn.get(1)).add(accn.get(i));
            }
        }

        // traverse the graph, find out all the connected subgraph
        Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();
        for(List<String> accn : accounts){
            if(!visited.contains(accn.get(1))){
                List<String> ans = new ArrayList<>();
                //bfs(graph,visited,accn.get(1), ans); // or
                dfs(graph,visited,accn.get(1),ans);
                Collections.sort(ans);
                ans.add(0, accn.get(0));
                result.add(ans);
            }
        }
        return result;
    }
    public void dfs(Map<String,Set<String>> graph, Set<String> visited, String s,List<String> ans){
        ans.add(s);
        visited.add(s);
        for(String str : graph.get(s)){
            if(!visited.contains(str))
                dfs(graph,visited,str,ans);
        }
    }


    public void bfs(Map<String,Set<String>> graph, Set<String> visited, String s, List<String> ans){
        Queue<String> q = new LinkedList<>();
        q.add(s);
        visited.add(s);
        while(!q.isEmpty()){
            String t = q.poll();
            ans.add(t);
            for(String str:graph.get(t)){
                if(!visited.contains(str)){
                    q.add(str);
                    visited.add(str);
                }
            }
        }
    }

    // this is the LeetCode's standard solution
//    public List<List<String>> accountsMerge(List<List<String>> accounts) {
//        Map<String, String> emailToName = new HashMap();
//        Map<String, ArrayList<String>> graph = new HashMap();
//        for (List<String> account: accounts) {
//            String name = "";
//            for (String email: account) {
//                if (name == "") { // this is essential, can not be commented off
//                    name = email;
//                    continue;
//                }
//                // this Java 8 way is good
//                graph.computeIfAbsent(email, x -> new ArrayList<>()).add(account.get(1));
//                graph.computeIfAbsent(account.get(1), x -> new ArrayList<>()).add(email);
//                emailToName.put(email, name);
//            }
//        }
//
//        Set<String> seen = new HashSet();
//        List<List<String>> ans = new ArrayList();
//        for (String email: graph.keySet()) {
//            if(seen.contains(email)) continue;
//            seen.add(email);
//            Stack<String> stack = new Stack();
//            stack.push(email);
//            List<String> components = new ArrayList();
//            while (!stack.empty()) {
//                String node = stack.pop();
//                components.add(node); // pay attention to this: this is the work horse!
//                for (String nei: graph.get(node)) {
//                    if (!seen.contains(nei)) {
//                        seen.add(nei);
//                        stack.push(nei);
//                    }
//                }
//            }
//            Collections.sort(components);
//            components.add(0, emailToName.get(email));
//            ans.add(components);
//        }
//        return ans;
//    }

}
