package com.practice.Hard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InvalidParenthesesTest {

    @Test
    public void removeInvalidParentheses() {
        InvalidParentheses invalidParentheses = new InvalidParentheses();
        String Input;
        List<String> Output, res;

        Input= "()())()";
        res = invalidParentheses.removeInvalidParentheses(Input);
        Output = Arrays.asList(new String[]{"()()()", "(())()"});
        assert(res.size() == Output.size());
        assert(res.size() == 1);


        Input = "(a)())()";
        res = invalidParentheses.removeInvalidParentheses(Input);
        Output = Arrays.asList(new String[]{"(a)()()", "(a())()"});
        assert(res.size() == Output.size());
        assert (res.size() == 2);


        Input= ")(";
        res = invalidParentheses.removeInvalidParentheses(Input);
        Output = new ArrayList<>();
        assert(res.size() == Output.size());
        assert(res.size() == 0);
    }
}