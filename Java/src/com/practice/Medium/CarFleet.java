package com.practice.Medium;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CarFleet {
    class Fleet{
        List<Integer> cars;
        int speed;
        int position;

        public Fleet(List<Integer>cars, int speed, int position){
            this.cars = cars;
            this.speed = speed;
            this.position = position;
        }

        List<Integer> getCars(){
            return cars;
        }

    }


    private void merge(List<Fleet> fleets, int i, int j, int k){
        Fleet fi = fleets.get(i);
        Fleet fj = fleets.get(j);

        if(i > j){
            fleets.remove(i);
            fleets.remove(j);
        }else{
            fleets.remove(j);
            fleets.remove(i);
        }

        List<Integer>combinedCars = fi.getCars();
        combinedCars.addAll(fj.getCars());
        Fleet newFleet = new Fleet(combinedCars, fi.speed<fj.speed ? fi.speed : fj.speed, fi.position + k);
        fleets.add(newFleet);
    }

    private boolean canMerge(List<Fleet> fleets, int i, int j, int k){
        Fleet fi = fleets.get(i);
        Fleet fj = fleets.get(j);
        fi.position += k;
        fj.position += k;
        return fi.position == fj.position;
    }

//    public int carFleet(int target, int[] position, int[] speed) {
////        List<Fleet> fleets = new ArrayList<>();
////        for(int i=0; i< speed.length; ++i){
////            List<Integer>cars = new ArrayList<>();
////            cars.add(position[i]);
////            Fleet f = new Fleet(cars, speed[i], position[i]);
////            fleets.add(f);
////        }
////
////        for(int t=1; t<=target; ++t){
////            for(int i=0; i<fleets.size()-1; i++){
////                for(int j=i+1; j<fleets.size(); j++){
////                    if(canMerge(fleets, i, j, t)){
////                        merge(fleets, i, j, t);
////                    }
////                }
////            }
////        }
////
////        int ret = fleets.size();
////        return ret;
////    }


    /** This one passed.
     *
     *  Tree mp, tree mp!! sorted
     *
     *  filtering by needed time to reach target!
     *
     *
     * @param target
     * @param position
     * @param speed
     * @return
     */
    public int carFleet(int target, int[] position, int[] speed) {

        // must use tree mp for we want the data extracted are in increasing order
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = position.length;
        for (int i = 0; i < n; ++i) {
            map.put(target - position[i], speed[i]);
        }

        int count = 0;
        double pacerTime = Double.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            double actualTime = 1.0 * entry.getKey() / entry.getValue();
            if (actualTime > pacerTime) { // any laggard is a fleet
                ++count;
                pacerTime = actualTime;
            }
        }
        return count;
    }
}
