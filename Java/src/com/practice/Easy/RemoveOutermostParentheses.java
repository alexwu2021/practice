package com.practice.Easy;

public class RemoveOutermostParentheses {

    public String removeOuterParentheses_lee215Way(String S) {

        // Add every char to the result,
        // unless the first left parenthesis,
        // and the last right parenthesis.

        StringBuilder s = new StringBuilder();
        int opened = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' && opened++ > 0) s.append(c);
            if (c == ')' && opened-- > 1) s.append(c);
        }
        return s.toString();
    }

    /** passed oj
     * @param S
     * @return
     */
    public String removeOuterParentheses(String S) {
        if(S == null || S.length() <= 1) return S;
        StringBuilder sb = new StringBuilder();
        int n = S.length();
        int stack = 0;
        for(int i = 0, j = 0; i < n; ++i) {
            if(S.charAt(i) == '(') stack++;
            else if(S.charAt(i) == ')') stack--;
            if(stack == 0){
                sb.append(S.substring(j+1, i));
                j = i + 1;
            }
        }
        return sb.toString();
    }

}
