package Easy;

import java.util.*;

/**
 * Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name,
 * and the rest of the elements are emails representing emails of the account.
 *
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email
 * that is common to both accounts. Note that even if two accounts have the same name, they may belong to different
 * people as people could have the same name. A person can have any number of accounts initially, but all of their
 * accounts definitely have the same name.
 *
 * After merging the accounts, return the accounts in the following format: the first element of each account is the
 * name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 */
public class AccountMerge {

    /** borrowed from adaZhang, passed oj for bfs and dfs
     * @param accounts
     * @return
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // build the graph
        Map<String, Set<String>> mpEmailToEmailSet = new HashMap<>();
        for(List<String> accn : accounts){
            for(int i = 1; i< accn.size(); ++i){
                String currentEmail = accn.get(i);
                if(!mpEmailToEmailSet.containsKey(currentEmail))
                    mpEmailToEmailSet.put(currentEmail,new HashSet<>());

                mpEmailToEmailSet.get(currentEmail).add(accn.get(1));
                mpEmailToEmailSet.get(accn.get(1)).add(currentEmail);
            }
        }

        // traverse the graph, find out all the connected subgraph
        Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();
        for(List<String> accn : accounts){
            if(!visited.contains(accn.get(1))){
                List<String> emailChains = new ArrayList<>();
                //bfs(graph,visited,accn.get(1), ans); // or
                dfs(mpEmailToEmailSet,visited,accn.get(1),emailChains);
                Collections.sort(emailChains);
                emailChains.add(0, accn.get(0));
                result.add(emailChains);
            }
        }
        return result;
    }
    public void dfs(Map<String,Set<String>> graph, Set<String> visited, String s,List<String> emailChains){
        emailChains.add(s);
        visited.add(s);
        for(String str : graph.get(s)){
            if(!visited.contains(str))
                dfs(graph,visited,str,emailChains);
        }
    }


//    public void bfs(Map<String,Set<String>> graph, Set<String> visited, String s, List<String> ans){
//        Queue<String> q = new LinkedList<>();
//        q.add(s);
//        visited.add(s);
//        while(!q.isEmpty()){
//            String t = q.poll();
//            ans.add(t);
//            for(String str:graph.get(t)){
//                if(!visited.contains(str)){
//                    q.add(str);
//                    visited.add(str);
//                }
//            }
//        }
//    }

    // this is the LeetCode's standard solution
    public List<List<String>> accountsMerge_official(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap();
        Map<String, ArrayList<String>> graph = new HashMap();
        for (List<String> account: accounts) {
            String name = "";
            for (String email: account) {
                if (name == "") { // this is essential, can not be commented off
                    name = email;
                    continue;
                }
                // this Java 8 way is good
                graph.computeIfAbsent(email, x -> new ArrayList<>()).add(account.get(1));
                graph.computeIfAbsent(account.get(1), x -> new ArrayList<>()).add(email);
                emailToName.put(email, name);
            }
        }

        Set<String> seen = new HashSet();
        List<List<String>> ans = new ArrayList();
        for (String email: graph.keySet()) {
            if(seen.contains(email)) continue;
            seen.add(email);
            Stack<String> stack = new Stack();
            stack.push(email);
            List<String> components = new ArrayList();
            while (!stack.empty()) {
                String node = stack.pop();
                components.add(node); // pay attention to this: this is the work horse!
                for (String nei: graph.get(node)) {
                    if (!seen.contains(nei)) {
                        seen.add(nei);
                        stack.push(nei);
                    }
                }
            }
            Collections.sort(components);
            components.add(0, emailToName.get(email));
            ans.add(components);
        }
        return ans;
    }

}
