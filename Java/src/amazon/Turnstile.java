package amazon;

import java.util.ArrayList;
import java.util.List;


public class Turnstile {
    class Student{
        protected int index;
        protected int arrivedTime;
        protected int totalTime; // wait time + passing time
        protected Student(int index, int arrivedTime, int totalTime){
            this.index = index;
            this.arrivedTime = arrivedTime;
            this.totalTime = totalTime;
        }
    }

    public int[] turnsTileFunction (int [] times, int [] directions) {
        int n = times.length;
        int[] ret = new int[n];

        List<Student> enter = new ArrayList<>();
        List<Student> leave = new ArrayList<>();

        int mx = -1;
        for(int i = 0; i< n; ++i) {
            if(i % 2 == 0)
                enter.add(new Student(i, times[i], 0));
            else
                leave.add(new Student(i, times[i], 0));
            mx = Math.max(mx, times[i]);
        }

        int previousDirection = -1; // 0 enter; 1 leave
        int s = 0;
        while(s <= mx){
            boolean updated = false;
            if(!enter.isEmpty() && !leave.isEmpty())
            {
                if(s < enter.get(0).arrivedTime && s < leave.get(0).arrivedTime){
                    s++;
                    previousDirection = -1;
                    continue;
                }

                if(s >= enter.get(0).arrivedTime && s >= leave.get(0).arrivedTime ) {
                    if( enter.get(0).arrivedTime == leave.get(0).arrivedTime) {
                        if(previousDirection == -1 || previousDirection == 1){
                            Student temp = leave.get(0);
                            leave.remove(0);
                            ret[temp.index] += 1;
                            previousDirection = 1;
                        }else{
                            Student temp = enter.get(0);
                            enter.remove(0);
                            ret[temp.index] += 1;
                            previousDirection = 0;
                        }
                        s++;
                        continue;
                    }

                    if(s >= enter.get(0).arrivedTime ) {
                        Student tempEnter = enter.get(0);
                        ret[tempEnter.index] += 1;
                        enter.remove(0);
                        previousDirection = 0;
                        s++;
                        continue;
                    }
                    if(s >= leave.get(0).arrivedTime ) {
                        Student tempEnter = enter.get(0);
                        ret[tempEnter.index] += 1;
                        leave.remove(0);
                        previousDirection = 1;
                        s++;
                        continue;
                    }
                }
            }

            if(!enter.isEmpty())
            {
                if(s < enter.get(0).arrivedTime){
                    s++;
                    previousDirection = -1;
                    continue;
                }
                Student temp = enter.get(0);
                if(previousDirection == -1 || previousDirection == 1){
                    ret[temp.index] += 1;
                }else{
                    ret[temp.index] += 1;
                    leave.remove(0);
                }
                s++;
                continue;
            }

            // similarly for the leave part
            if(!leave.isEmpty())
            {
                if(s < leave.get(0).arrivedTime){
                    s++;
                    previousDirection = -1;
                    continue;
                }
                Student temp = leave.get(0);
                if(previousDirection == -1 || previousDirection == 1){
                    ret[temp.index] += 1;
                    leave.remove(0);
                }else{
                    ret[temp.index] += 1;

                }
                s++;
                continue;
            }
            s++;
        }
        return ret;
    }
}
