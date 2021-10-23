package Easy;

import java.util.*;
import java.util.Arrays;

import static com.google.common.primitives.Ints.asList;

public class ThirdMaxInteger {

    public int thirdMax(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int n: nums) st.add(n);
        Queue<Integer> pq=new PriorityQueue<>((a, b) ->(b % Integer.MAX_VALUE - a % Integer.MAX_VALUE));
        for(int n : st) pq.offer(n);
        if(pq.size() < 3) return pq.peek();
        pq.poll();
        pq.poll();
        return pq.peek();
    }
}
