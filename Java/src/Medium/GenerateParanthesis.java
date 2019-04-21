package Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GenerateParanthesis {
	//this one not passed, but easy to understand

    public List<String> generateParenthesis_mine(int n) {
        List<String>ret = new ArrayList<String>();
        if(n == 1){
            ret.add("()");
            return ret;
        }

        List<String>result = generateParenthesis(n-1);
        HashSet<String> hs = new HashSet<String>();
        for(String s: result){
            hs.add(s + "()");
            hs.add( "()" + s );
            hs.add("(" + s + ")");
        }

        for(String t: hs){
            ret.add(t);
        }
        return ret;
    }
    
    //accepted
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
    public void backtrack(List<String> list, String str, int open, int close, int max){
        
        if(str.length() == max*2){
            list.add(str);
            return;
        }
        
        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
}