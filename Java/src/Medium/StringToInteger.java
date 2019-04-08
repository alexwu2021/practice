package Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringToInteger {
    private static final Set<Character> digits = new HashSet<>(Arrays.asList(new Character[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}));
    private static final int TENS_OF_MAX = Integer.MAX_VALUE / 10;
    private static final int REM_OF_MAX = Integer.MAX_VALUE % 10;

    public static int atoi(String str) {
        if(str == null || str.length() == 0) return 0;
        int num = 0, i = 0, sign = 1, signCount = 0, n = str.length();

        while(i < n && str.charAt(i) == ' ' && i < str.length()) { i++; }

        while(i < n && !digits.contains(str.charAt(i))) {
            if(str.charAt(i) == '+') {
                signCount++;
                sign = 1;
            } else if(str.charAt(i) == '-') {
                signCount++;
                sign = -1;
            } else{
                return 0;
            }
            i++;
        }

        if(signCount >= 2) return 0;

        while( i  < n) {
            char ch = str.charAt(i);
            if(!digits.contains(ch)) break;
            int temp = ch - '0';
            if(TENS_OF_MAX < num || TENS_OF_MAX == num && REM_OF_MAX < temp) return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            num = num * 10 + temp;
            i++;
        }

        return sign * num;
    }
}
