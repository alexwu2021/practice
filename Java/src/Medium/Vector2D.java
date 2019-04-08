package Medium;

/*
failed at this test case and will revisit later

and error message is
java.lang.ArrayIndexOutOfBoundsException: 2
  at line 57, Vector2D.next
  at line 57, __Driver__.__helperSelectMethod__
  at line 78, __Driver__.__helper__

test case is

["Vector2D","next","next","next","hasNext","hasNext","next","hasNext"]
[[[[1,2],[3],[4]]],[null],[null],[null],[null],[null],[null],[null]]
*/

public  class Vector2D {
    private int iList, iElement;
    private int [][] vec;

    public Vector2D(int[][] vec2d) {
        iList = 0;
        iElement = 0;
        vec = vec2d;
    }

    public int next() {
        return vec[iList][iElement++];
    }

    public boolean hasNext() {
        while(iList < vec.length){
            if(iElement < vec[iList].length)
                return true;
            iList++;
            iElement = 0;
        }
        return false;
    }
}


//public class Vector2D{
//
//    int iList, iElement;
//    List<List<Integer>> vec;
//
//    public Vector2D(List<List<Integer>> vec2d) {
//        iList = 0;
//        iElement = 0;
//        vec = vec2d;
//    }
//
//    public int next() {
//        return vec.get(iList).get(iElement++);
//    }
//
//    public boolean hasNext() {
//        while(iList < vec.size()){
//            if(iElement < vec.get(iList).size())
//                return true;
//            iList++;
//            iElement = 0;
//        }
//        return false;
//    }
//}



/**
 * Design and implement an iterator to flatten a 2d vector. It should support the following operations: next and hasNext.
 *
 *
 * the following is from StefanPochemann but it has interface issue
 *
 */
//public class Vector2D {
//
//    private Iterator<List<Integer>> _listIterator;
//    private Iterator<Integer> integerIterator;
//
//    public Vector2D(List<List<Integer>> vec2d) {
//        _listIterator = vec2d.iterator();
//    }
//
//    public int next() {
//        hasNext(); // forced to call hasNext first
//        return integerIterator.next();
//    }
//
//    public boolean hasNext() {
//        // set up integerIterator
//        while ((integerIterator == null || !integerIterator.hasNext()) && _listIterator.hasNext())
//            integerIterator = _listIterator.next().iterator();
//
//        return integerIterator != null && integerIterator.hasNext();
//    }
//}

// initial view
//class Vector2D {
//
//    public Vector2D(int[][] v) {
//
//    }
//
//    public int next() {
//
//    }
//
//    public boolean hasNext() {
//
//    }
//}
//
///**
// * Your Vector2D object will be instantiated and called as such:
// * Vector2D obj = new Vector2D(v);
// * int param_1 = obj.next();
// * boolean param_2 = obj.hasNext();
// */
//

//    Vector2D iterator = new Vector2D([[1,2],[3],[4]]);
//
//        iterator.next(); // return 1
//        iterator.next(); // return 2
//        iterator.next(); // return 3
//        iterator.hasNext(); // return true
//        iterator.hasNext(); // return true
//        iterator.next(); // return 4
//        iterator.hasNext(); // return false