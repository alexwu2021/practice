//package com.practice.SystemDesign;
//
////import com.google.common.collect.HashBasedTable;
////import com.google.common.collect.Table;
//
//import java.util.Map;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class BaseRateLimiter {
//    private static final int LIMIT_OF_REQUESTS_IN_TIME_SPAN = 10;
//    private static final Long TIME_SPAN = 60 * 1000L;
//
//    private Table<String, Long, Integer> IPAndTimeAndVisistsTable = HashBasedTable.create();
//    private ReentrantLock reentrantLock = new ReentrantLock();
//
//    public boolean isClientAllowed(String clientId) {
//        boolean ret;
//        long timeInSecond = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
//        if (IPAndTimeAndVisistsTable.containsRow(clientId)) {
//            Set<Map.Entry<Long, Integer>> entries = IPAndTimeAndVisistsTable.row(clientId).entrySet();
//            // get key and value of the data
//            for (Map.Entry<Long, Integer> item : entries) {
//                if (timeInSecond - item.getKey() < TIME_SPAN || item.getValue() > LIMIT_OF_REQUESTS_IN_TIME_SPAN) {
//                    ret =  false;
//                    break;
//                }
//            }
//            ret = true;
//        } else {
//            try {
//                reentrantLock.lock();
//                IPAndTimeAndVisistsTable.put(clientId, timeInSecond, 1);
//                ret = true;
//            } catch (Exception e) {
//                e.printStackTrace();
//                ret = false;
//            } finally {
//                reentrantLock.unlock();
//            }
//        }
//
//        new IPAndTimeAndVisistsTableCleanerRunnnable( new CleanerParam(clientId, timeInSecond)).run();
//
//        return ret;
//    }
//
//    protected class CleanerParam{
//        protected String clientID;
//        protected Long currentTimeSpan;
//
//        protected CleanerParam(String clientID, Long currentTimeSpan){
//            clientID = clientID;
//            currentTimeSpan = currentTimeSpan;
//        }
//    }
//
//    protected class IPAndTimeAndVisistsTableCleanerRunnnable implements Runnable {
//        private CleanerParam cleanerParam;
//
//        public IPAndTimeAndVisistsTableCleanerRunnnable(Object parameter) {
//            this.cleanerParam = (CleanerParam)parameter;
//        }
//
//        public void run() {
//            if (!IPAndTimeAndVisistsTable.containsRow(this.cleanerParam.clientID)) {
//                return;
//            }
//            for (Map.Entry<Long, Integer> item : IPAndTimeAndVisistsTable.row(this.cleanerParam.clientID).entrySet()) {
//                if (item.getKey() < this.cleanerParam.currentTimeSpan ){
//                    IPAndTimeAndVisistsTable.row(this.cleanerParam.clientID).remove(item.getKey());
//                }
//            }
//        }
//    }
//}