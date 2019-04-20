package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Design and implement an iterator to flatten a 2d vector. It should support the following operations: next and hasNext.
 *
 *
 *
 * Example:
 *
 * Vector2D iterator = new Vector2D([[1,2],[3],[4]]);
 *
 * iterator.next(); // return 1
 * iterator.next(); // return 2
 * iterator.next(); // return 3
 * iterator.hasNext(); // return true
 * iterator.hasNext(); // return true
 * iterator.next(); // return 4
 * iterator.hasNext(); // return false
 *
 *
 * Notes:
 *
 * Please remember to RESET your class variables declared in Vector2D, as static/class variables are persisted across multiple test cases. Please see here for more details.
 * You may assume that next() call will always be valid, that is, there will be at least a next element in the 2d vector when next() is called.
 *
 *
 * Follow up:
 *
 * As an added challenge, try to code it using only iterators in C++ or iterators in Java.
 *
 */
public class Vector2DFollowUp {

    private Iterator<List<Integer>> i;
    private Iterator<Integer> j;

    /**
     * @param vect2d
     *
     * Runtime: 57 ms, faster than 81.03% of Java online submissions for Flatten 2D Vector.
     * Memory Usage: 49.1 MB, less than 38.51% of Java online submissions for Flatten 2D Vector.
     */
    public Vector2DFollowUp(int[][] vect2d) {
        List<List<Integer>>res = new ArrayList<>();
        for(int[] u: vect2d){
            List<Integer> lst = new ArrayList<>();
            for(int v: u) lst.add(v);
            res.add(lst);
        }
        i = res.iterator();
    }

    public int next() {
        hasNext();
        return j.next();
    }

    public boolean hasNext() {
        while (i.hasNext()){
            if(j == null || !j.hasNext())
                j = i.next().iterator();
            else break;
        }
        return j != null && j.hasNext();
    }
}
