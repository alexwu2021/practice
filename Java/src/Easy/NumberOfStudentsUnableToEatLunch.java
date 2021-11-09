package Easy;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfStudentsUnableToEatLunch {


    public int countStudents_efficient(int[] st, int[] sn) {
        int count[] = {0, 0}, n = st.length, k;
        for (int a: st) count[a]++;
        for (k = 0; k < n && count[sn[k]] > 0; ++k) count[sn[k]]--;
        return n - k;
    }

    public int countStudents(int[] st, int[] sn) {
        int i = 0, n = sn.length;
        Queue<Integer> q = new LinkedList<>();
        for(int s : st) {
            q.offer(s);
        }

        outer:
        while(i < n){
            int j = 0; // to prevent endless loop
            while(q.peek() != sn[i]){
                q.offer(q.poll());
                j++;
                if(j > q.size() ){
                    break outer;
                }
            }
            // student on the front of q takes sandwich i
            q.poll();
            i++;
        }
        return n - i ;
    }
}
