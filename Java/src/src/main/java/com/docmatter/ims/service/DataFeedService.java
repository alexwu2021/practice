package com.docmatter.ims.service;

import java.util.*;

public class DataFeedService implements IDataFeedService {
    private static int MAX_NUMBER_OF_RECORDS = 1000_000;
    private static int MAX_ACTIVITY_COUNT_AT_ONE_TIME = 5;

    @Override
    public void populateInMemoryDataStructure(Map<Integer, Map<Integer, Map<Integer, Integer>>> mp,
                                              List<Integer> users, List<Integer>days, List<Integer> activities) {
        Random random = new Random(System.currentTimeMillis());

        int numberOfRecords = MAX_NUMBER_OF_RECORDS;
        System.out.println("Going to populate with " + numberOfRecords + " records for " + users.size() + " users on the span of " + days.size() + " days for per user max activity count set at " + MAX_ACTIVITY_COUNT_AT_ONE_TIME);
        for(int i=0; i<numberOfRecords; ++i){
            int userIndex = random.nextInt(users.size());
            int userId = users.get(userIndex);
            Map<Integer, Map<Integer, Integer>>userDailyStats = mp.get(userId);

            Map<Integer, Integer>dailyStat;

            int dayIndex = random.nextInt(days.size());
            int dayId = days.get(dayIndex);
            if(userDailyStats.containsKey(dayId)){
                dailyStat = userDailyStats.get(dayId);
            }else{
                dailyStat = new HashMap<>();
                userDailyStats.put(dayId, dailyStat);
            }

            int activityIndex = random.nextInt(activities.size());
            int activityId = activities.get(activityIndex);
            int count = 1 + random.nextInt(MAX_ACTIVITY_COUNT_AT_ONE_TIME);
            dailyStat.put(activityId, dailyStat.getOrDefault(activityId, 0) + count);
        }
    }
}
