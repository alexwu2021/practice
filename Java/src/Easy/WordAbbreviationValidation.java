package Easy;

public class WordAbbreviationValidation {

    public boolean validWordAbbreviation(String word, String abbr) {

        String resulting = "";
        int n = word.length(), m = abbr.length();
        int i = 0, j = 0, k = -1;

        do{
            while(i < n && j < m && word.charAt(i) == abbr.charAt(j)) {
                resulting += word.charAt(i);
                i++;
                j++;
            }


            if(i == n && j == m && word.equals(resulting))
                return true;

            if(j < m &&  abbr.charAt(j) == '0'  && (k == -1 || j - 1 == k ))
                return false;
            if (j < m && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9'){
                int tempj = j;
                while (j < m && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9'){
                    j++;
                }
                int len = Integer.parseInt(abbr.substring(tempj, j - 1));
                resulting += word.substring(i, len);

                i += len;
                k = i ;
            }
        } while (i < n && j < m);

        if(i == n){
            if(j < m) return false;
        }

        if(j == m){
            if(i < n) return false;
        }

        return word.equals(resulting);
    }

}
