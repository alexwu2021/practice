package Medium;

import java.util.*;

public class BasicCalculator {
    public int calculate(String s) {
        if(s == null)
            return 0;
        s = s.replace(" ", "");
        if(s.startsWith("-"))
            s = "0" + s;
        Deque<String> deq = new LinkedList<>();
        int n = s.length();
        int i=0;
        while(i < n){
            if(s.charAt(i) != ')'){
                deq.offer(Character.toString(s.charAt(i)));
            }else{
                deq.offer(Integer.toString(popAndCalc(deq)));
            }
            i++;
        }
        int ans = popAndCalc(deq);
        return ans;
    }

    private int popAndCalc(Deque<String> deque) {
        List<String> lst = new ArrayList<>();
        while(!deque.isEmpty() && !deque.peekLast().equals("(")) {
            String s = deque.removeLast();
            lst.add(0, s);
        }
        if(!deque.isEmpty() && deque.peekLast().equals("("))
            deque.removeLast();

        StringBuffer sb = new StringBuffer();
        for(String t: lst)
            sb.append(t);
        String target = sb.toString();
        return DoTheMath(target);
    }

    private int DoTheMath(String s) {
        if(s == null || s.length() <= 0)
            return 0;

        s = s.replace("--", "+");
        if(s.indexOf("+") <0 && s.indexOf("-") <0)
            return Integer.valueOf(s);

        int val = 0;
        int n = s.length();
        int i = 0, j = i, k, r;
        int neg = 1;
        if(s.startsWith("-")){
            neg = -1;
            j++;
        }

        while(j < n && s.charAt(j) != '+' && s.charAt(j) != '-'){
            j++;
        }
        int left = Integer.valueOf(s.substring(i, j)) * neg;

        k= j+ 1;
        r = k;
        while(r < n && s.charAt(r) != '+' && s.charAt(r) != '-'){
            r++;
        }

        int right = Integer.valueOf(s.substring(k, r));
        if(s.charAt(j) == '+'){
            val = left + right ;
        }else{
            val = left - right ;
        }
        if(r == n)
            return val;

        String remaining = s.substring(r+1);
        return val + DoTheMath(remaining);
    }
}
