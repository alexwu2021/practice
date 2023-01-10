package com.docmatter.ims.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class ImsDeserializer {
    private String _filePathName;

    public Map<Integer, Map<Integer, Map<Integer, Integer>>> readFromFile(String persistenceFilePathName) {
        this._filePathName = persistenceFilePathName;

        Map<Integer, Map<Integer, Map<Integer, Integer>>> ret = new HashMap<>();
        BufferedReader bufferedReader = null;
        Reader fstream = null;
        long recordCount = 0;
        int defaultCharBufferSize = 100_000;
        try {
            fstream = new InputStreamReader(new FileInputStream(this._filePathName), StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(fstream, defaultCharBufferSize);

            String line = bufferedReader.readLine();
            while(line != null && line.length() >0 ){
                processOneLine(ret, line);
                line = bufferedReader.readLine();
                recordCount++;
            }
            System.out.println(recordCount + " records read from file " + this._filePathName);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                bufferedReader.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("Deserialzed the whole data structure from file " + this._filePathName);
        return ret;
    }

    private void processOneLine(Map<Integer, Map<Integer, Map<Integer, Integer>>> mp, String line) {
        int i = 0, j = line.length()-1;
        while(line.charAt(i) != ' '){
            i++;
        }
        int subjectId = Integer.valueOf(line.substring(0, i));
        if(!mp.containsKey(subjectId)) mp.put(subjectId, new HashMap<>());
        while(line.charAt(i) != '{'){
            i++;
        }
        while(line.charAt(i) != ' '){
            i++;
        }
        while(line.charAt(j) != '}'){
            j--;
        }
        while(line.charAt(j) != ' '){
            j--;
        }
        processDailyRecords(mp.get(subjectId), line.substring(i, j));
        return;
    }

    private void processDailyRecords(Map<Integer, Map<Integer, Integer>>dailMap, String dailyRecords) {
        int i=0, j = i;
        while(j < dailyRecords.length()) {
            // eat away the beginning white spaces
            while(i < dailyRecords.length() && dailyRecords.charAt(i) == ' '){
                i++;
            }
            j = i;
            while(j < dailyRecords.length() && dailyRecords.charAt(j) != '|'){
                j++;
            }
//            System.out.println("daily record string: [" + dailyRecords.substring(i, j) + "]");
            processSingleDayRecords(dailMap, dailyRecords.substring(i, j));

            // move pass the '|' char
            j ++;

            //begin another round
            i = j;
        }
    }

    private void processSingleDayRecords(Map<Integer, Map<Integer, Integer>> dailyRecords, String dayActivities) {
//        System.out.println("dayActivities substring is [" + dayActivities + "]");
        int i = 0, j = dayActivities.length()-1;
        while(i < dayActivities.length() && dayActivities.charAt(i) != ' '){
            i++;
        }
        int dayId = Integer.valueOf(dayActivities.substring(0, i));
        if(!dailyRecords.containsKey(dayId)) dailyRecords.put(dayId, new HashMap<>());
        while(i < dayActivities.length() && dayActivities.charAt(i) != '['){
            i++;
        }
        while(i < dayActivities.length() && dayActivities.charAt(i) != ' '){
            i++;
        }

        // stripe off the trailing white spaces
        while(j >= 0 && dayActivities.charAt(j) == ' '){
            j--;
        }

        // get pass over ']'
        while(j >= 0 && dayActivities.charAt(j) != ']'){
            j--;
        }

        // eat away the white spaces preceding ']'
        while(j >= 0 && dayActivities.charAt(j) == ' '){
            j--;
        }

//        System.out.println("dayActivities substring is " + dayActivities.substring(i, j));
        processActiviesOnASingleDay(dailyRecords.get(dayId), dayActivities.substring(i, j));

    }

    private void processActiviesOnASingleDay(Map<Integer, Integer> activityMap, String activities) {
        int i=0, j = activities.length()-1;
        while(i < activities.length() && activities.charAt(i) == ' '){
            i++;
        }
        while(j >=0 && activities.charAt(j) == ' '){
            j--;
        }
        String[] pairs = activities.substring(i, j + 1).split(",");
        for(String pair: pairs){
//            System.out.println("pair found to be [" + pair + "]");
            if(pair.length() <= 0)
                continue;
            String[] sa = pair.split(":", 2);
            Integer key = Integer.valueOf(sa[0]), val = Integer.valueOf(sa[1]);
            if(!activityMap.containsKey(key)){
                activityMap.put(key, val);
            }else{
                activityMap.put(key, activityMap.get(key) + val);
            }
        }
    }

    public void setSourceFileName(String persistenceFilePathName) {
        this._filePathName = persistenceFilePathName;
    }
}
