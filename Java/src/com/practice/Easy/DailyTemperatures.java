package com.practice.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DailyTemperatures {

    /**
     *
     * monotonic stack of element indices
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];

        for(int i = n - 1; i >= 0; --i) {

            // lower or equal are liberated by the coming i
            while(!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]) {
                st.pop();
            }

            // If the stack still has elements, then the next warmer temperature exists!
            if(!st.isEmpty()) {
                ans[i] = st.peek() - i; // by definition
            }

            // Inserting current index in the stack: monotonicity is maintained
            st.push(i);
        }

        return ans;
    }
}
