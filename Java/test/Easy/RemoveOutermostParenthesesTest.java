package Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveOutermostParenthesesTest {

    @Test
    public void removeOuterParentheses() {
        RemoveOutermostParentheses removeOutermostParentheses = new RemoveOutermostParentheses();
        String s = "(()())(())";
        String res = removeOutermostParentheses.removeOuterParentheses(s);
        assert(res.equals("()()()"));

        s = "()()";
        res = removeOutermostParentheses.removeOuterParentheses(s);
        assert(res.equals(""));

        s = "()";
        res = removeOutermostParentheses.removeOuterParentheses(s);
        assert(res.equals(""));
    }
}