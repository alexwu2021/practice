package com.practice.Easy;

public class ImplementStrStr {


    /**
     * @param haystack
     * @param needle
     * @return the index of first ocurrance of needle in haystack
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;

        int j = 0;
        for (int i = 0; i < haystack.length(); ++i) {

            //相等的话计数加 1
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;

                //长度够了就返回
                if (j == needle.length()) return i - j + 1;
            }

            // 不相等的话 j 清零，
            // 并且 i 回到最初的位置，之后就进入 for 循环中的 i++，从下个位置继续判断
            else {
                i = i - j; // this is the place that easily gets wrong, we need reset it to the starting position
                j = 0;
            }
        }
        return -1;
    }
}
