package Unclassified;

import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduler {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[][] matrix = new int[numCourses][numCourses]; // matrix[i][j] means course j depends on course i
        int[] dep = new int[numCourses]; // inDegree[i] means how many courses depending on i

        for (int i = 0; i < prerequisites.length; ++i) {
            int self = prerequisites[i][0];
            int pre = prerequisites[i][1];
            dep[self]++;
            matrix[pre][self] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < dep.length; ++i) {
            if (dep[i] == 0) queue.offer(i);
        }

        int indpCount = 0; // independent course count
        while (!queue.isEmpty()) {
            int currCourse = queue.poll();
            indpCount++;
            for (int i = 0; i < numCourses; ++i) {
                if (matrix[currCourse][i] != 0) {
                    if (--dep[i] == 0)
                        queue.offer(i);
                }
            }
        }

        return indpCount == numCourses;
    }


//    public boolean canFinish_forStudying(int NUM_OF_COURSES, int[][] prerequisites) {
//
//        int[][] matrix = new int[NUM_OF_COURSES][NUM_OF_COURSES]; // matrix[i][j] means course j depends on course i
//        int[] dep = new int[NUM_OF_COURSES]; // inDegree[i] means how many courses depending on i
//
//        for (int i = 0; i < prerequisites.length; ++i) {
//            int self = prerequisites[i][0];
//            int pre = prerequisites[i][1];
//
//            //if (matrix[pre][self] == 0){
//            dep[self]++;
//                // this is correct
//                //dep[self]++;
//
//                // and this is wrong
//                //dep[pre]++;
//            //}
//
//            matrix[pre][self] = 1;
//            //System.out.println("i=" + i  + ", self=" + self + ", dep[self]=" + dep[self]);
//        }
//
//        //we cannot do this
////        for (int i = 0; i < prerequisites.length; ++i) {
////            int self = prerequisites[i][0];
////            int pre = prerequisites[i][1];
////            if (matrix[pre][self] == 0)
////                dep[self]++;
////        }
//
//
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < dep.length; ++i) {
//            if (dep[i] == 0)
//                queue.offer(i);
//        }
//
//        int indpCount = 0; // independent course count
//        while (!queue.isEmpty()) {
//            int currCourse = queue.poll();
//            indpCount++;
//            for (int i = 0; i < NUM_OF_COURSES; ++i) {
//                if (matrix[currCourse][i] != 0) {
//                    if (--dep[i] == 0)
//                        queue.offer(i);
//                }
//            }
//        }
//
//        return indpCount == NUM_OF_COURSES;
//    }

//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        Map<Integer, List<Integer>> mp = new HashMap<>();
//        for(int[] pair: prerequisites){
//            Integer key = pair[0];
//            Integer val = pair[1];
//            if(mp.containsKey((key))){
//                mp.get(key).add(val);
//            } else {
//                List newVales =new ArrayList<Integer>();
//                newVales.add(val);
//                mp.put(key, newVales);
//            }
//
//        }
//
//        boolean ret = true;
//        for(int[] pair: prerequisites){
//            List<Integer> path = new ArrayList<>();
//            path.add(pair[0]);
//            if(hasCycle(path, mp)){
//                ret = false;
//                break;
//            }
//        }
//        return ret;
//    }
//
//    private boolean hasCycle(List<Integer> path, Map<Integer, List<Integer>>mp){
//        if(path.size() <= 0) return false;
//
//        Integer curr = path.get(path.size()-1);
//        if(!mp.containsKey(curr)) {
//            return false;
//        }
//
//        List<Integer> vals = mp.get(curr);
//        for(Integer val: vals){
//            if(path.contains(val)) {
//                if(!mp.containsKey(val))
//                    return false;
//
//                Set<Integer>deps = new HashSet<>(mp.get(val));
//                for(Integer pth: path){
//                    if(deps.contains(pth))
//                        return true;
//                }
//            }
//
//            path.add(val);
//            if(hasCycle(path, mp))
//                return true;
//        }
//        return false;
//    }
}

