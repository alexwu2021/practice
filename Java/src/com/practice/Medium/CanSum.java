//package Medium;
//
//import sun.misc.SoftCache;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
///**
// * given a non-negative integer array and a target integer, determine
// * if we can sum up 1 or multiple element to make this target up b
// *
// */
//public class CanSum {
//    private Map<String, Boolean>mp = new HashMap<>();
//    public boolean canSum(int target, int[] nums){
//        if(nums == null || nums.length <= 0)
//            return false;
//
//        List<Integer> lst = new ArrayList<>();
//        for(int n : nums) lst.add(n);
//        return canSumHelper(target, lst);
//    }
//
//    private boolean canSumHelper(int target, List<Integer> lst) {
//        if(target < 0)
//            return false;
//
//        if(lst.size() == 1 && lst.get(0) == target)
//            return true;
//
//        if(mp.getOrDefault(lst.stream().map(String::valueOf).collect(Collectors.joining(",")), false))
//            return true;
//
//        for(int i=0; i<lst.size(); ++i){
//            int curr = lst.get(i);
//            int nextTarget = target - curr;
//
//            List<Integer>nextList = new ArrayList<>(lst);
//            nextList.remove(i);
//            if(canSumHelper(nextTarget, nextList) || canSumHelper(target, nextList)){
//                String repr = nextList
//                        .stream().map(String::valueOf)
//                        .collect(Collectors.joining(","));
//
//                mp.put(repr, true);
//                return true;
//            }
//
//        }
//        return false;
//    }
//}
