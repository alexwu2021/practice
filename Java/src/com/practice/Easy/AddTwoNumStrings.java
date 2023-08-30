package com.practice.Easy;

public class AddTwoNumStrings {

    public String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null) return null;
        if (num2.length() > num1.length()) return addStrings(num2, num1);

        int m = num1.length(), n = num2.length();
        int carry = 0;
        StringBuilder res = new StringBuilder();
        for (int i = m - 1, j = n - 1; j >= 0; --i, --j) {
            int temp = carry + (num1.charAt(i) - '0') + (num2.charAt(j) - '0');
            carry = temp / 10;
            res.append(temp % 10 + "");
        }

        for (int k = m - n - 1; k >= 0; --k) {
            int temp = carry + num1.charAt(k) - '0';
            carry = temp / 10;
            res.append(temp % 10 + "");
        }

        while (carry > 0) {
            res.append(carry % 10 + "");
            carry /= 10;

        }

        return res.reverse().toString();
    }

}
