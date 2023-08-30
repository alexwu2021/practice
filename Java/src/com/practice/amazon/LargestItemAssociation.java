package com.practice.amazon;

import java.util.*;

class PairString {
    String first;
    String second;

    public PairString(String first, String second) {
        this.first = first;
        this.second = second;
    }
}

public class LargestItemAssociation {
    public List<String> largestItemAssociation_someones(List<PairString> itemAssociation) {
        Map<String, List<String>> mpAssoc = new HashMap<>();


        //Map with all items and child association of every item 1->2, 2-> , 3->4, 4->5 ,5->
        for (PairString p : itemAssociation) {
            if(p.first.equals(p.second))
                continue;
            if (!mpAssoc.containsKey(p.first)) {
                mpAssoc.put(p.first, new ArrayList<>());
            }
            mpAssoc.get(p.first).add(p.second);
            if (!mpAssoc.containsKey(p.second)) {
                mpAssoc.put(p.second, new ArrayList<>());
            }

            // we should not do this
//            mpAssoc.computeIfAbsent(p.first, x->new ArrayList<>()).add(p.first);
//            mpAssoc.get(p.first).add(p.second);
//            mpAssoc.computeIfAbsent(p.second, x->new ArrayList<>()).add(p.second);
        }

        //DFS for every item: Resultant map 1->{5},{2} 2->{1,2},{4,5} 3->{3,4,5}
        Map<Integer, List<List<String>>> mpSizeToList = new HashMap<>();
        int maxSize = Integer.MIN_VALUE;
        for (String key : mpAssoc.keySet()) {
            Queue<String> q = new LinkedList<>();
            q.offer(key);

            TreeSet<String> tsGroup = new TreeSet<>();
            while (!q.isEmpty()) {
                String head = q.poll();
                tsGroup.add(head);
                List<String> tail = mpAssoc.get(head);
                for (String t : tail)
                    q.offer(t);
            }

            int size = tsGroup.size();
            maxSize = Math.max(maxSize, size);
            mpSizeToList.computeIfAbsent(size, x->new ArrayList<>()).add(new ArrayList<>(tsGroup));
        }

        // Retrieve the maximum size lists and sort them lexiographically
        List<List<String>> maxAssoc = mpSizeToList.get(maxSize);
        Collections.sort(maxAssoc, (o1, o2)-> {
                int result = 0;
                for (int i = 0; i < o1.size() && result == 0; ++i) {
                    result = o1.get(i).compareTo(o2.get(i));
                }
                return result;
        });
        return maxAssoc.get(0);
    }

    public List<String> largestItemAssociation(List<PairString> itemAssociation) {

        int k = 2;
        boolean done = false;

        List<Set<String>>ksets = new ArrayList<>();
        for(PairString ps: itemAssociation){
            Set<String> temp =new HashSet<String>();
            temp.add(ps.first);
            temp.add(ps.second);
            ksets.add(temp);
        }

        boolean changed = false;
        do {
            changed = false;
            List<Set<String>>ksets2 = new ArrayList<>();

            outloop:
            for (int i = ksets.size() - 1; i >= 1; i -= 2) {
                for (int j = i - 1; j >= 0; --j) {
                    if (CanMerge(ksets.get(i), ksets.get(j))) {
                        Set<String> tempSet = new HashSet<>(ksets.get(i));
                        tempSet.addAll(new HashSet<String>(ksets.get(j)));
                        ksets.remove(i);
                        ksets.remove(j);
                        ksets2.add(tempSet);
                        changed = true;
                        break outloop;
                    }
                }
            }
            if(ksets2.size() > 0)
                ksets.addAll(ksets2);
        }while(changed);

        return new ArrayList<String>(ksets.get(0));
    }

    private boolean CanMerge(Set<String> s1, Set<String> s2) {
        for(String s : s1){
         if(s2.contains(s))
             return true;
        }

        for(String s : s2){
            if(s1.contains(s))
                return true;
        }
        return false;
    }
}
