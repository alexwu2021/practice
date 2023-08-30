package com.practice.Easy;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stk  = new Stack<Character>();
        for(char c: s.toCharArray()){
            switch(c){
                case '(':
                case '[':
                case '{':
                    stk.push(c);
                    break;
                case ')':
                    if(!stk.empty()){
                        if(stk.peek()== '(')
                            stk.pop();
                        else
                            return false;

                    }else{
                        return false;
                    }
                    break;
                case ']':
                    if(!stk.empty()){
                        if(stk.peek()=='['){
                            stk.pop();
                        }else{
                            return false;
                        }
                    }else{
                        return false;
                    }
                    break;
                case '}':
                    if(!stk.empty()){
                        if(stk.peek()=='{'){
                            stk.pop();
                        }else{
                            return false;
                        }
                    }else{
                        return false;
                    }
            }
        }
        return stk.empty();
    }

}
