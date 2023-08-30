package com.practice.Easy;

public class BackspacedStringCompare {

    int getIndex(String str, int idx){
        for (int back = 0; idx >= 0 && (back > 0 || str.charAt(idx) == '#'); --idx)
            back += str.charAt(idx) == '#' ? 1 : -1;
        return idx;
    }

    /** passed oj
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        while (true) {
            i = getIndex(S, i);
            j = getIndex(T, j);
            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--; j--;
            } else {
                return i == -1 && j == -1;
            }
        }
    }
}
