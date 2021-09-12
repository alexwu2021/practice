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
        target = target.replace("--", "+");
        return DoTheMath(target, 0);
    }

    private int DoTheMath(String original, int i) {
        String s= original.substring(i);
        if(s.indexOf("+") <0 && s.indexOf("-") <0)
            return Integer.valueOf(s);
        if(s.length() <= 0)
            return 0;

        int val = 0;
        int n = s.length();

        int j = i, k, r;
        while(j < n && s.charAt(j) != '+' && s.charAt(j) != '-'){
            j++;
        }
        int left = Integer.valueOf(s.substring(i, j));

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

        if(s.charAt(r) == '+')
            return val + DoTheMath(original, r+1);
        return val - DoTheMath(original, r+1);
    }
//    private int DoTheMath(List<String>lst) {
//        if(lst.size() <= 0)
//            return 0;
//
//        boolean hasOperand = false;
//        StringBuffer sb = new StringBuffer();
//        for(String s: lst){
//            sb.append(s);
//            if(s.equals("+") || s.equals("-"))
//                hasOperand = true;
//        }
//        if(!hasOperand)
//            return Integer.valueOf(sb.toString());
//
//        int left = Integer.valueOf(lst.get(0));
//        int right = Integer.valueOf(lst.get(2));
//        String mid =lst.get(1);
//        for(int j = 0; j<=2; ++j)
//            lst.remove(0);
//
//        int ret = 0;
//        if(mid.equals("+")){
//            ret = left + right;
//        }else{
//            ret = left - right;
//        }
//
//        if(lst.size() ==0)
//            return ret;
//        lst.add(0, String.valueOf(ret));
//        return DoTheMath(lst);
//    }
}
