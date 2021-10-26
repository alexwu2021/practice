package Medium;

import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] a) {
        Stack<Integer> stack = new Stack<>();
        for (int curr: a) {
            if (stack.isEmpty() || curr > 0) {
                stack.push(curr);
                continue;
            }

            // curr <= 0
            do{
                int top = stack.peek();
                if (top < 0) {
                    stack.push(curr);
                    break;
                }

                // top is positive

                if (top == -curr) { // explod off
                    stack.pop();
                    break;
                }

                if (top > -curr) break; // conquered curr

                // top is smaller than -curr
                stack.pop(); // this will evantually be killed by curr

                // corner case
                if (stack.isEmpty()) {
                    stack.push(curr);
                    break;
                }
            }while(true);
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
