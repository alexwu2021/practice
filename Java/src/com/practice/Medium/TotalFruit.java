package com.practice.Medium;

public class TotalFruit {


    class Tracker{
        public int kind;
        public int endIndex;
        public int count;

        public Tracker(int kind, int endIndex, int count){
            this.kind = kind;
            this.endIndex = endIndex;
            this.count = count;
        }
        public Tracker(Tracker other){
            this.kind = other.kind;
            this.endIndex = other.endIndex;
            this.count = other.count;
        }
    }

    public int totalFruit(int[] fruits) {

        int ans = Integer.MIN_VALUE;
        int maxSoFar = Integer.MIN_VALUE;

        Tracker[] trackers = new Tracker[2];
        int i = 0;
        trackers[0] = new Tracker(fruits[0], i, 1);
        setup(fruits, trackers[0]);

        i = trackers[0].endIndex + 1;
        trackers[1] = new Tracker(fruits[i], i, 1);
        setup(fruits, trackers[1]);

        maxSoFar = trackers[0].count + trackers[1].count;
        ans = Math.max(maxSoFar, ans);

        i = trackers[1].endIndex +1;
        while(i < fruits.length){
            Tracker head = trackers[0];

            Tracker newTail;
            if(fruits[i] == head.kind){
                newTail = new Tracker(head);
                while(i < fruits.length && fruits[i] == newTail.kind){
                    newTail.endIndex = i;
                    newTail.count++;
                }
            }else{
                newTail = new Tracker(fruits[i], i, 1);
                setup(fruits, newTail);
            }
            trackers[0] = trackers[1];
            trackers[1] = newTail;
            maxSoFar = trackers[0].count + trackers[1].count;
            ans = Math.max(maxSoFar, ans);
        }

        return ans;
    }

    void setup(int [] fruits, Tracker tracker){
        int i = tracker.endIndex;
        while(i < fruits.length -1 && fruits[i+1] == fruits[i]){
            i++;
            tracker.endIndex++;
            tracker.count++;
        }
    }
}