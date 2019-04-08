package Medium;

public class ZigZagConversion {

    /** passed oj
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if(numRows <= 1) return s;
        StringBuilder[] sbs = new StringBuilder[numRows];
        for(int i = 0; i < sbs.length; ++i)
            sbs[i] = new StringBuilder();

        int idx = 0, adj = 1;
        for(Character ch: s.toCharArray()){
            sbs[idx].append(ch);
            if(idx == 0) adj = 1;
            if(idx == numRows - 1) adj = -1;
            idx += adj;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(StringBuilder sb: sbs) stringBuilder.append(sb.toString());
        return stringBuilder.toString();
    }
}


// pay attention to the pitfall: the following way does not work
// for(StringBuilder sb: sbs)
//   sb = new StringBuilder();
