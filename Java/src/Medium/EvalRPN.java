package Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 */
public class EvalRPN {

    public int evalRPN(String[] tokens) {
        int a, b;
        Stack<Integer> S = new Stack<>();
        for (String s : tokens) {
            if(s.equals("+")) {
                S.add(S.pop()+S.pop());
            }
            else if(s.equals("/")) {
                b = S.pop();
                a = S.pop();
                S.add(a / b);
            }
            else if(s.equals("*")) {
                S.add(S.pop() * S.pop());
            }
            else if(s.equals("-")) {
                b = S.pop();
                a = S.pop();
                S.add(a - b);
            }
            else {
                S.add(Integer.parseInt(s));
            }
        }
        return S.pop();
    }
}
