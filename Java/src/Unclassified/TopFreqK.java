package Unclassified;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopFreqK {


    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>ret = new ArrayList<>();
        if(nums == null) return ret;

        Map<Integer, Integer> mp = new HashMap<>();
        for(int n: nums){
            mp.put(n, mp.getOrDefault(n, 0) + 1);
        }

        int len = nums.length;
        List<Integer>[] list = new List[len + 1]; // pay attention to the rhs in initilization; also 1 is for zero in freq
        for(int key: mp.keySet()){
            int freq = mp.get(key);
            if(list[freq] == null) list[freq] = new ArrayList<Integer>();
            list[freq].add(key);
        }

        done:
        for(int m = list.length-1; m>= 0; m--){
            if(list[m] != null){
                for(int tbi : list[m]){
                    if(ret.size() >= k)
                        break done;
                    ret.add(tbi);
                }
            }
        }
        return ret;
    }


//    private class MyNode{
//        public int val;
//        public int freq;
//        public MyNode(int val, int freq){
//            this.val = val;
//            this.freq = freq;
//        }
//    }
//
//    public List<Integer> topKFrequent(int[] nums, int k) {
//        List<Integer>ret = new ArrayList<>();
//        if(nums == null)
//            return ret;
//
//        Map<Integer, Integer> mp = new HashMap<>();
//        for(int n: nums){
//            int temp = mp.getOrDefault(n, 0) + 1;
//            mp.put(n, temp);
//            if(temp >= k && !ret.contains(n)){
//                ret.add(n);
//            }
//        }
//
//        if(ret.size() >= k)
//            return ret;
//
//        List<MyNode> nodeList = new ArrayList<>();
//        for(int key : mp.keySet()){
//            if(mp.get(key) < k){
//                nodeList.add(new MyNode(key, mp.get(key)));
//            }
//        }
//
//        Collections.sort(nodeList, (a, b)-> {
//            if(a.freq > b.freq) return 0;
//            else if (a.freq == b.freq) return 1;
//            else return -1;
//        });
//
//        int i = nodeList.size() -1;
//        while(ret.size() < k && i < nodeList.size()){
//            ret.add(nodeList.get(i).val);
//            i--;
//        }
//
//        return ret;
//    }

}
