package Easy;
import java.util.*;

public class DupsInArray {


    /**
     * @param source an integer array containing integers between 1 and length of this array, inclusive
     * @return an integer array that contains all the dups
     */
    public int[] getAllTheDups(int[] source){
        List<Integer> ret = new ArrayList<>() ;
        for(int i=0; i<source.length; ++i){
            int index = Math.abs(source[i]) -1;
            if(source[index] < 0){
                ret.add(Math.abs(source[index]));
                continue;
            }
            source[index] = -1 * source[index];
        }
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
}
