package com.practice.Hard;

import java.util.Stack;

public class TrapRainWater {
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int left = 0, right = height.length - 1;
        int area = 0, leftHeight = height[0], rightHeight = height[height.length - 1];
        while (left < right){
            if (height[left] < height[right]){
                left++;
                leftHeight = Math.max(leftHeight, height[left]);
                area += leftHeight - height[left];
            } else{
                right--;
                rightHeight = Math.max(rightHeight, height[right]);
                area += rightHeight - height[right];
            }
        }
        return area;
    }

    /**
     * passed oj
     * @param height
     * @return
     */
    public int trap_stack(int[] height) {
        int ans = 0;
        Stack<Integer>stk = new Stack<>();
        int i = 0;
        while(i < height.length){
            while(!stk.isEmpty() && height[i] > height[stk.peek()]){
                int oldStackHi = height[stk.peek()];
                stk.pop();

                if(stk.isEmpty()) break;

                int dis = (i- stk.peek() -1);
                int newHigherHi = Math.min(height[stk.peek()], height[i]);

                ans += dis * (newHigherHi - oldStackHi);
            }
            stk.push(i++);
        }
        return ans;
    }

}
