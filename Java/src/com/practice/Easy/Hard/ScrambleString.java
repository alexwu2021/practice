package com.practice.Easy.Hard;

/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 *
 * Below is one possible representation of s1 = "great":
 *
 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 *
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 *
 *     rgeat
 *    /    \
 *   rg    eat
 *  / \    /  \
 * r   g  e   at
 *            / \
 *           a   t
 * We say that "rgeat" is a scrambled string of "great".
 *
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 *
 *     rgtae
 *    /    \
 *   rg    tae
 *  / \    /  \
 * r   g  ta  e
 *        / \
 *       t   a
 * We say that "rgtae" is a scrambled string of "great".
 *
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 *
 * Example 1:
 *
 * Input: s1 = "great", s2 = "rgeat"
 * Output: true
 * Example 2:
 *
 * Input: s1 = "abcde", s2 = "caebd"
 * Output: false
 */
public class ScrambleString {

    /**
     * cut the passed in string into two segments
     * with the first element being the first segment if mode is true, being the second segment if otherwise
     * with the second element the remaining segment
     * @param s
     * @param index
     * @param mode
     * @return
     */
    String[] getSegments(String s, int index, boolean mode){
        if(mode)
            return new String[]{s.substring(0, index), s.substring(index)};
        return new String[]{s.substring(s.length() - index), s.substring(0, index)};
    }

    public boolean isScramble(String s1, String s2) {
        if( s1.equals(s2) ) return true;

        int N = s1.length();
        int counter1[] = new int[26];
        int counter2[] = new int[26];
        for(int i = 0; i < N; ++i) {
            counter1[s1.charAt(i) - 'a']++;
            counter2[s2.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; ++i){
            // if frequencies not match, then no need to go further
            if( counter1[i] != counter2[i] ) return false;
        }

        for(int i = 1; i < N; ++i) {
            String[] sa1 = getSegments(s1, i, true);
            String[] sa2 = getSegments(s2, i, true);
            if( isScramble(sa1[0], sa2[0]) && isScramble(sa1[1], sa2[1]) )
                return true;

            sa2 = getSegments(s2, i, false);
            if( isScramble(sa1[0], sa2[0]) && isScramble(sa1[1], sa2[1]) )
                return true;

            //due to symmetry, we can skip the remaining cases
        }
        return false;
    }
}
