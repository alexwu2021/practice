package Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GoatLatin {

    public String toGoatLatin_MostPractical(String S) {
        Set<Character> vowel = new HashSet<Character>();
        for (char c : "aeiouAEIOU".toCharArray()) vowel.add(c);

        String res = "";
        int i = 0, j = 0;
        for (String w : S.split("\\s")) {
            res += ' ' + (vowel.contains(w.charAt(0)) ? w : w.substring(1) + w.charAt(0)) + "ma";
            for (j = 0, ++i; j < i; ++j) res += "a";
        };

        return res.substring(1); //to toss off the front ' '
    }



    //private static final List<Character> vowels = Arrays.asList(new Character[]{'a', 'o', 'e', 'i', 'u', 'A', 'O', 'E', 'I', 'U'});

    //will use the following
    private static final Character[] vowelsList = new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
    private static final Set<Character> vowels = new HashSet<>(Arrays.asList(vowelsList));

    public String toGoatLatin(String S) {
        if(S == null || S.length() <= 0)
            return S;

        StringBuilder sb = new StringBuilder();
        int i = 0, len = S.length();
        int wordIndex = -1;
        while(i < len){
            while(i < len && S.charAt(i) == ' '){
                sb.append(S.charAt(i));
                i++;
            }

            boolean isVowel = false;
            int start = i, end;
            while(i < len && S.charAt(i)  != ' '){
                if(vowels.contains( S.charAt(start) )){
                    isVowel = true;
                }
                i++;
            }
            end = i;
            wordIndex++;
            sb.append(processAWord(S, start, end, isVowel, wordIndex));
        }
        return sb.toString();
    }

    private String processAWord(String S, int start, int end, boolean isVowel, int wordIndex){
        StringBuilder ret = new StringBuilder();
        if(!isVowel){
            ret.append(S.substring(start + 1, end) + S.charAt(start));
        }else{
            ret.append(S.substring(start, end));
        }

        ret.append("ma");
        for(int i=0; i<wordIndex + 1; ++i){
            ret.append("a");
        }

        return ret.toString();
    }


    // someone else's solution
//    public static final Character[] vowelsList = new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
//    public static final HashSet<Character> vowels = new HashSet<Character>(Arrays.asList(vowelsList));

    public String toGoatLatin_Others(String S) {
        if(S == null || S.length() == 0) {
            return "";
        }
        StringBuilder answer = new StringBuilder();
        int wordIndex = 1;

        for (String word : S.split(" ")) {
            if (wordIndex != 1) {
                answer.append(" ");
            }
            char firstCharacter = word.charAt(0);
            if (vowels.contains(firstCharacter)) {
                answer.append(word);
            } else {
                answer.append(word.substring(1));
                answer.append(firstCharacter);
            }
            answer.append("ma");
            for (int i = 0; i < wordIndex; i++) {
                answer.append("a");
            }
            wordIndex++;
        }

        return answer.toString();
    }
}
