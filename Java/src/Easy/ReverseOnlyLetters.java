package Easy;

public class ReverseOnlyLetters {

    private boolean isSkippable(char ch){
        if(ch - 'A' < 0 || ch - 'z'> 0)
            return true;
        if(ch -'Z'>0  && ch - 'a' < 0)
            return true;
        return false;
    }

    public String reverseOnlyLetters(String s) {
        int i = 0, n = s.length();
        int j = n-1;
        char[] ss = s.toCharArray();
        while (i< j){
            char ch = ss[i];
            if(isSkippable(ch)){
                i++;
                continue;
            }
            while(j >= 0 && isSkippable(ss[j]) && j > i){
                j--;
            }
            if(j <= i)
                break;

            char temp = ss[j];
            ss[j] = ch;
            ss[i] = temp;
            i++;
            j--;
        }
        return String.valueOf(ss);
    }
}
