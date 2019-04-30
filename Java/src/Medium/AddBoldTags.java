package Medium;

import CommonTypes.Interval;
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


    /** ------------------------------------------------------------------------
     * Originally from helloworldzt,
     * improved by me,
     * now it has:
     * Runtime: 9 ms
     * Memory Usage: 39.6 MB
     *
     * @param s
     * @param dict
     * @return
     */
    //public String addBoldTag_helloworldzt(String s, String[] dict) {
    public String addBoldTag(String s, String[] dict) {
        Set<Interval> st = new TreeSet<>();
        for (String str : dict) {
            int index = -1;
            index = s.indexOf(str, index);
            while (index != -1) {
                Interval temp = new Interval(index, index + str.length());
                st.add(temp);
                index += 1;
                index = s.indexOf(str, index);
            }
        }
        if(st.size() <= 0) return s;

        List<Interval>intervals = merge(st);

        StringBuilder sb = new StringBuilder();
        int prev = 0;
        for (Interval interval : intervals) {
            sb.append(s.substring(prev, interval.start))
                    .append(PRE)
                    .append(s.substring(interval.start, interval.end))
                    .append(POST);
            prev = interval.end;
        }
        if (prev < s.length()) sb.append(s.substring(prev));
        return sb.toString();
    }


    public List<Interval> merge(Set<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() <= 0) return res;
        if (intervals.size() == 1) {
            res.add(intervals.iterator().next());
            return res;
        }

        Iterator<Interval> iter = intervals.iterator();
        Interval front = iter.next();
        int start = front.start;
        int end = front.end;

        while(iter.hasNext()){
            Interval i = iter.next();
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


    /** ------------------------------------------------------------------
     * this is the better one becasue it is more concise, but its time is 12 ms
     * @param s
     * @param dict
     * @return
     */
    public String addBoldTag__shawngo(String s, String[] dict) {
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
            while (j < s.length() && bold[j]) { j++; }
            result.append("<b>" + s.substring(i, j) + "</b>");
            i = j - 1;
        }

        return result.toString();
    }


    /** --------------------------------------------------------------------------------
     *  TODO: OJ passed, but not happy with the performance, need revisited later
     *
     *
     * @param s
     * @param dict
     * @return
     */
    public String addBoldTag_mine(String s, String[] dict) {
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

}