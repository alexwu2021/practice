package amazon;

import java.util.*;

/*
Given 2 lists a and b. Each element is a pair of integers where the first integer represents the unique id and the second integer represents a value. Your task is to find an element from a and an element form b such that the sum of their values is less or equal to target and as close to target as possible. Return a list of ids of selected elements. If no pair is possible, return an empty list.

Example 1:

Input:
a = [[1, 2], [2, 4], [3, 6]]
b = [[1, 2]]
target = 7

Output: [[2, 1]]

Explanation:
There are only three combinations [1, 1], [2, 1], and [3, 1], which have a total sum of 4, 6 and 8, respectively.
Since 6 is the largest sum that does not exceed 7, [2, 1] is the optimal pair.
Example 2:

Input:
a = [[1, 3], [2, 5], [3, 7], [4, 10]]
b = [[1, 2], [2, 3], [3, 4], [4, 5]]
target = 10

Output: [[2, 4], [3, 2]]

Explanation:
There are two pairs possible. Element with id = 2 from the list `a` has a value 5, and element with id = 4 from the list `b` also has a value 5.
Combined, they add up to 10. Similarily, element with id = 3 from `a` has a value 7, and element with id = 2 from `b` has a value 3.
These also add up to 10. Therefore, the optimal pairs are [2, 4] and [3, 2].
Example 3:

Input:
a = [[1, 8], [2, 7], [3, 14]]
b = [[1, 5], [2, 10], [3, 14]]
target = 20

Output: [[3, 1]]
Example 4:

Input:
a = [[1, 8], [2, 15], [3, 9]]
b = [[1, 8], [2, 11], [3, 12]]
target = 20

Output: [[1, 3], [3, 2]]


 */
public class MostCloseValuePairs {

    public class SumAndIds{
        public int sm;
        public int[] pairs;
        public SumAndIds(int sum, int[] pairs){
            this.sm = sum;
            this.pairs = pairs;
        }
    }

    class SumAndIdsComparator implements Comparator<SumAndIds>{

        // Overriding compare()method of Comparator
        // for descending order of cgpa
        public int compare(SumAndIds s1, SumAndIds s2) {
            if (s1.sm > s2.sm)
                return -1;
            else if (s1.sm < s2.sm)
                return 1;
            return 0;
        }
    }

    public List<int[]> getPairs(List<int[]> a, List<int[]> b, int target) {
        List<int[]> ret = new ArrayList<>();
        Map<Integer, List<Integer>> valToIda = new HashMap<>();
        Map<Integer, List<Integer>> valToIdb = new HashMap<>();
        Set<Integer>anumbers = new HashSet<>();
        Set<Integer>bnumbers = new HashSet<>();

        PriorityQueue<SumAndIds> pq = new PriorityQueue<>( new SumAndIdsComparator());

        for(int[] aItem: a){
            List<Integer> list = valToIdb.get(aItem[1]);
            if(list == null)
                list = new ArrayList<>();
            list.add(aItem[0]);
            valToIda.put(aItem[1], list);
            anumbers.add(aItem[1]);
        }

        for(int[] bItem: b){
            List<Integer> list = valToIdb.get(bItem[1]);
            if(list == null)
                list = new ArrayList<>();
            list.add(bItem[0]);
            valToIdb.put(bItem[1], list);
            bnumbers.add(bItem[1]);
        }

        for(Integer n: anumbers){
            int diff = target - n;
            if(diff < 0) continue;
            for (Integer m : bnumbers) {
                if (m <= diff ) {
                    int sum = n + m;
                    if(pq.isEmpty() || (!pq.isEmpty() && sum >= pq.peek().sm)){
                        addToQueue(pq, sum, valToIda.get(n),  valToIdb.get(m));
                    }
                }
            }
        }

        int largestSeen = Integer.MIN_VALUE;
        while(!pq.isEmpty()){
           SumAndIds sumAndIds =  pq.poll();
           if(largestSeen == Integer.MIN_VALUE) {
               largestSeen = sumAndIds.sm;
           }
           if(sumAndIds.sm == largestSeen){
               ret.add(sumAndIds.pairs);
           }else if(sumAndIds.sm < largestSeen){
               break;
           }
        }
        return ret;
    }

    private void addToQueue(PriorityQueue<SumAndIds> pq, int i, List<Integer> alist, List<Integer> blist) {
        for(Integer a : alist){
            for(Integer b : blist){
                pq.add(new SumAndIds(i, new int[]{a, b}));
            }
        }
    }

}
