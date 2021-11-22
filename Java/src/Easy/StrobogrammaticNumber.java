package Easy;

/**
 * Given a string num which represents an integer, return true if num is a strobogrammatic number.
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        return dfs(num, 0, num.length()-1, 0);
    }

    private boolean dfs(String num, int s, int e, int level){
        if(e < s) return true;
        if(e == s){
            if(num.charAt(s) == '1' || num.charAt(s) == '8')
                return true;
            else if(level >= 1 && num.charAt(s) =='0' )
                return true;
            return false;
        }

        if(num.charAt(s) == '6' && num.charAt(e) == '9')
            return dfs(num, s+1, e-1, level+1);
        if(num.charAt(s) == '9' && num.charAt(e) == '6')
            return dfs(num, s+1, e-1, level+1);
        if(num.charAt(s) == '1' && num.charAt(e) == '1')
            return dfs(num, s+1, e-1, level+1);
        if(num.charAt(s) == '8' && num.charAt(e) == '8')
            return dfs(num, s+1, e-1, level+1);
        if(num.charAt(s) == '0' && num.charAt(e) == '0' && level >=1)
            return dfs(num, s+1, e-1, level+1);
        return false;
    }
}
