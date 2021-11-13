package Easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> st = new HashSet<>();
        for(String e: emails){
            String[] sa = e.split("@", 2);
            int index = sa[0].indexOf("+");
            if(index > 0) sa[0] = sa[0].substring(0, index);
            st.add(sa[0].replace(".", "") +"@"+ sa[1]);
        }
        return st.size();
    }
}
