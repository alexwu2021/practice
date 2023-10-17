package com.practice.Hard;

import java.util.HashMap;
import java.util.Map;

/**
 *  Runtime: 14 ms, faster than 6.22% of Java online submissions for Integer to English Words.
 * Memory Usage: 37.8 MB, less than 5.18% of Java online submissions for Integer to English Words.
 *
 */
public class NumberToWords {

    Map<Integer, String> mp = new HashMap<>();
    private static final int HUNDRED = 100;
    private static final int THOUSAND = 1000;
    private static final int MILLION = 1000000;
    private static final int BILLION = 1000000000;

    private void setup(){
        for(int n = 99; n >= 1; --n){
            boolean isTeen = false;
            StringBuilder s = new StringBuilder();
            int p = n / 10;
            if(p > 0){
                switch (p){
                    case 9: s.append("Ninety").append(" "); break;
                    case 8: s.append("Eighty").append(" "); break;
                    case 7: s.append("Seventy").append(" "); break;
                    case 6: s.append("Sixty").append(" "); break;
                    case 5: s.append("Fifty").append(" "); break;
                    case 4: s.append("Forty").append(" "); break;
                    case 3: s.append("Thirty").append(" "); break;
                    case 2: s.append("Twenty").append(" "); break;
                    case 1: if(n  == (p) * 10 ) s.append("Ten"); else isTeen = true;  break;
                    default: break;
                }
            }

            int m = n - p * 10;
            if(isTeen){
                switch(m){
                    case 9: s.append("Nineteen"); break;
                    case 8: s.append("Eighteen"); break;
                    case 7: s.append("Seventeen"); break;
                    case 6: s.append("Sixteen"); break;
                    case 5: s.append("Fifteen"); break;
                    case 4: s.append("Fourteen"); break;
                    case 3: s.append("Thirteen"); break;
                    case 2: s.append("Twelve"); break;
                    case 1: s.append("Eleven"); break;
                    default: break;
                }
            }else{
                switch(m){
                    case 9: s.append("Nine"); break;
                    case 8: s.append("Eight"); break;
                    case 7: s.append("Seven"); break;
                    case 6: s.append("Six"); break;
                    case 5: s.append("Five"); break;
                    case 4: s.append("Four"); break;
                    case 3: s.append("Three"); break;
                    case 2: s.append("Two"); break;
                    case 1: s.append("One"); break;
                    default: break;
                }
            }
            mp.put(n, s.toString().trim());
        }
    }


    private int processOneK(StringBuilder sb, int num, int unit, String unitName) {
        int temp = num / unit;
        if (temp > 0) {
            sb.append(getExp(temp));
            if (sb.toString().length() > 0)
                sb.append(unitName).append(" ");
            num -= temp * unit;
        }
        return num;
    }


    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        setup();
        StringBuilder sb = new StringBuilder();
        num = processOneK(sb, num, BILLION, "Billion");
        num = processOneK(sb, num, MILLION, "Million");
        num = processOneK(sb, num, THOUSAND, "Thousand");

        if(num > 0) sb.append(getExp(num));

        return sb.toString().trim();
    }

    private String getExp(int num){
        if(num == 0) return "";
        StringBuilder sb = new StringBuilder();
        int h = num / HUNDRED;
        if(h > 0) sb.append(mp.get(h)). append(" ").append("Hundred").append(" ");

        num -= h * HUNDRED;
        if(num > 0) sb.append(mp.get(num)).append(" ");
        return sb.toString();
    }
}

//
//
//class otherElegantSolution{
//    private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
//    private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
//    private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
//
//    public String numberToWords(int num) {
//        if (num == 0) return "Zero";
//        return helper(num);
//    }
//
//    private String helper(int num) {
//        String result = new String();
//        if (num < 10) result = belowTen[num];
//        else if (num < 20) result = belowTwenty[num -10];
//        else if (num < 100) result = belowHundred[num/10] + " " + helper(num % 10);
//        else if (num < 1000) result = helper(num/100) + " Hundred " +  helper(num % 100);
//        else if (num < 1000000) result = helper(num/1000) + " Thousand " +  helper(num % 1000);
//        else if (num < 1000000000) result = helper(num/1000000) + " Million " +  helper(num % 1000000);
//        else result = helper(num/1000000000) + " Billion " + helper(num % 1000000000);
//        return result.trim();
//    }
//}