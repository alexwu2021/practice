package com.practice.Hard;

import java.util.ArrayDeque;
import java.util.Deque;

class MaxBooksToPick {
    long getSummation(int n) {
        if(n < 0) return 0;
        return (long)n * (long)(n + 1) / 2;
    }

    public long maximumBooks(int[] books) {

        long[] dp = new long[books.length];
        Deque<Integer> stack = new ArrayDeque();
        long maxBooks = 0;

        for (int i = 0; i < books.length; ++i) {

            while (!stack.isEmpty() && books[stack.peek()] >= books[i] - i + stack.peek())
                stack.pop();

            // pick dp[j] books and (books[i] + books[i] - 1 + ... + books[i] -
            // (i - j - 1)) books, where j is the current stack top
            long topVal = stack.isEmpty() ? 0 : dp[stack.peek()];
            int b = books[i] - i + (stack.isEmpty() ? -1 : stack.peek());
            dp[i] =  topVal + getSummation(books[i]) - getSummation(b);
            maxBooks = Math.max(maxBooks, dp[i]);

            stack.push(i);
        }

        return maxBooks;

    }
}