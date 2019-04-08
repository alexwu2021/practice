package Easy;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {

    public List<String> commonChars(String[] A) {
        List<String> ret = new ArrayList<>();
        if(A == null || A.length <= 0) return ret;
        int[] base = new int[26];
        for(Character ch: A[0].toCharArray()) base[ch - 'a']++;

        for(int i = 1; i < A.length; ++i){
            int[] temp = new int[26];
            for(Character ch: A[i].toCharArray()) temp[ch - 'a']++;
            for(int j = 0; j < 26; ++j) base[j] = Math.min(base[j], temp[j]);
        }

        for(int k = 0; k < 26; ++k){
            while(base[k] > 0) ret.add("" + (char)('a' + k) );
        }
        return ret;
    }
}
