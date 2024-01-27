package com.practice.Design;

import java.util.*;
public class Allocator {
    Map<Integer, List<int[]>>mp;
    private int[] mem;
    public Allocator(int n) {
        mp = new HashMap<>();
        mem = new int[n];
        Arrays.fill(mem, -1);
    }

    public int allocate(int size, int mID) {
        int start = 0, end = 0, count = 0, ans = -1;
        for(int i=0; i< this.mem.length; ++i){
            if(this.mem[i] == -1){
                count++;
            } else {
                count = 0;
                start = i + 1;
            }
            if(count == size){
                end = i;
                break;
            }
        }
        if(start > end) return -1;
//        System.out.println("start " + start + " end: " + end);
        Arrays.fill(this.mem, start, Math.min(end+1, this.mem.length), 1);
        mp.computeIfAbsent(Integer.valueOf(mID), x->new ArrayList<>()).add(new int[]{start, end});
        ans = end - start + 1;
        return ans;
    }

    public int free(int mID) {
        List<int[]>allocates = this.mp.get(Integer.valueOf(mID));
        if(allocates == null) return 0;

        int ans = 0;
        for(int[] al: allocates){
            ans += al[1] - al[0] + 1;
            Arrays.fill(this.mem, al[0], al[1]+1, -1);
        }
        return ans;
    }
}
