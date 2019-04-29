package Medium;

import java.util.*;

/**
 * #616
 *
 * Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to wrap the substrings in s that exist in dict. If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag. Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.
 * Example 1:
 * Input:
 * s = "abcxyz123"
 * dict = ["abc","123"]
 * Output:
 * "<b>abc</b>xyz<b>123</b>"
 * Example 2:
 * Input:
 * s = "aaabbcc"
 * dict = ["aaa","aab","bc"]
 * Output:
 * "<b>aaabbc</b>c"
 * Note:
 * The given dict won't contain duplicates, and its length won't exceed 100.
 * All the strings in input have length in range [1, 1000].
 */

public class AddBoldTags {
    private  static final String PRE = "<b>";
    private  static final String POST = "</b>";

    private class Interval {
        int start;
        int end;
        Interval(int s, int e) { start = s; end = e; }
    }


    /**
     *  TODO: OJ passed, but not happy with the performance, need revisited later
     *
     *
     * @param s
     * @param dict
     * @return
     */
    public String addBoldTag(String s, String[] dict) {
        if(s == null || s.length() <= 0 || dict == null || dict.length <= 0)
            return s;

        // take the indices of the matched word to store them in a list
        Set<Interval> intervalSet = new HashSet<>();
        for(String word : dict){
            int start = 0;
            while(start < s.length()){
                String substr = s.substring(start);
                int foundIndex = substr.indexOf(word);
                if(foundIndex >= 0){
                    intervalSet.add(new Interval(start + foundIndex, start + foundIndex + word.length() -1));
                }
                start ++;
            }
        }
        if(intervalSet.size() <= 0) return s;

        // sort and merge
        List<Interval> places = merge(new ArrayList<>(intervalSet));;
        places.sort((i1, i2) -> i2.start - i1.start);

        // wrapp up by inserting the tags
        StringBuffer sb = new StringBuffer();
        Stack<String>stk = new Stack<>();
        for(Interval interval: places){
            String tail = s.substring(interval.end + 1);
            String head = s.substring(interval.start, interval.end + 1);
            stk.push(PRE + head + POST + tail);
            s = s.substring(0, interval.start);
        }

        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }

        if(s != null && s.length() > 0)
            return s + sb.toString();
        return sb.toString();
    }

    private List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) return intervals;

        intervals.sort((i1, i2) -> i1.start - i2.start);

        List<Interval> result = new LinkedList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (int i = 1; i< intervals.size(); ++i) {
            if(intervals.get(i).start <= end + 1){
                end = Math.max(end, intervals.get(i).end);
            } else {
                result.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }

        result.add(new Interval(start, end));
        return result;
    }


// a lot for me to learn
 class Solution_helloworldzt {
        public String addBoldTag(String s, String[] dict) {
            List<Interval> intervals = new ArrayList<>();
            for (String str : dict) {
                int index = -1;
                index = s.indexOf(str, index);
                while (index != -1) {
                    intervals.add(new Interval(index, index + str.length()));
                    index +=1;
                    index = s.indexOf(str, index);
                }
            }
            System.out.println(Arrays.toString(intervals.toArray()));
            intervals = merge(intervals);
            System.out.println(Arrays.toString(intervals.toArray()));
            int prev = 0;
            StringBuilder sb = new StringBuilder();
            for (Interval interval : intervals) {
                sb.append(s.substring(prev, interval.start));
                sb.append("<b>");
                sb.append(s.substring(interval.start, interval.end));
                sb.append("</b>");
                prev = interval.end;
            }
            if (prev < s.length()) {
                sb.append(s.substring(prev));
            }
            return sb.toString();
        }

        class Interval {
            int start, end;
            public Interval(int s, int e) {
                start = s;
                end = e;
            }

            public String toString() {
                return "[" + start + ", " + end + "]" ;
            }
        }

        public List<Interval> merge(List<Interval> intervals) {
            if (intervals == null || intervals.size() <= 1) {
                return intervals;
            }
            Collections.sort(intervals, new Comparator<Interval>(){
                public int compare(Interval a, Interval b) {
                    return a.start - b.start;
                }
            });

            int start = intervals.get(0).start;
            int end = intervals.get(0).end;
            List<Interval> res = new ArrayList<>();
            for (Interval i : intervals) {
                if (i.start <= end) {
                    end = Math.max(end, i.end);
                } else {
                    res.add(new Interval(start, end));
                    start = i.start;
                    end = i.end;
                }
            }
            res.add(new Interval(start, end));
            return res;
        }
    }

}


// this is the better one
class Solution_shawngo {
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for (int i = 0, end = 0; i < s.length(); i++) {
            for (String word : dict) {
                if (s.startsWith(word, i)) {
                    end = Math.max(end, i + word.length());
                }
            }
            bold[i] = end > i;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!bold[i]) {
                result.append(s.charAt(i));
                continue;
            }
            int j = i;
            while (j < s.length() && bold[j]) j++;
            result.append("<b>" + s.substring(i, j) + "</b>");
            i = j - 1;
        }

        return result.toString();
    }
}