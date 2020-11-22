package Hard;

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
    public int trap_stack(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {

            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()]; //取出要出栈的元素
                stack.pop(); //出栈
                if (stack.empty())  // 栈空就出去
                    break;

                int distance = current - stack.peek() - 1; //两堵墙之前的距离, 1 means the pillar itself

                int min = Math.min(height[stack.peek()], height[current]);
                sum +=  distance * (min - h);
            }

            stack.push(current); //当前指向的墙入栈
            current++; //指针后移
        }
        return sum;
    }

}
