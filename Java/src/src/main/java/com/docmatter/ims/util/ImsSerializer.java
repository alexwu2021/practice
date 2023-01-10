package com.docmatter.ims.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static com.docmatter.ims.constant.ImsConstant.MB_SIZE;

public class ImsSerializer {
    private String _filePathName;


    public void setOutputFileName(String filePathName){
        this._filePathName = filePathName;
    }

    public void dumpToFile(Map<Integer, Map<Integer, Map<Integer, Integer>>> ds){
        System.out.println("before dumping, size of ds is " + ds.size());
        BufferedWriter bufferedWriter = null;
        Writer fstream = null;
        BufferedWriter out = null;
        int defaultCharBufferSize = 100_000;
        try {
            fstream = new OutputStreamWriter(new FileOutputStream(this._filePathName, false), StandardCharsets.UTF_8);
            bufferedWriter = new BufferedWriter(fstream, defaultCharBufferSize);
            for(Map.Entry<Integer, Map<Integer, Map<Integer, Integer>>>entry: ds.entrySet()){

                // have to go this way to avoid strange characters
                bufferedWriter.write(new Integer(entry.getKey()).toString() + " { ");

                int dailyRecordsSize = entry.getValue().entrySet().size();
                int d = -1;
                for(Map.Entry<Integer, Map<Integer, Integer>>subEntry: entry.getValue().entrySet()){
                    d++;
                    bufferedWriter.write(subEntry.getKey() + " [ ");
                    int activitySize = subEntry.getValue().entrySet().size();
                    int a = -1;
                    for(Map.Entry<Integer, Integer>activityRecord: subEntry.getValue().entrySet()){
                        a++;
                        bufferedWriter.write(activityRecord.getKey() + ":" + activityRecord.getValue());
                        if(a <= activitySize - 2)
                            bufferedWriter.write(",");
                    }
                    bufferedWriter.write(" ] ");
                    if(d <= dailyRecordsSize-2)
                        bufferedWriter.write(" | ");
                }
                bufferedWriter.write(" } ");
                bufferedWriter.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                bufferedWriter.close();
                File file = new File(this._filePathName);
                long fileSize = FileUtil.getFileSize(file);
                System.out.println("The size of file " + this._filePathName + " is " + (double)fileSize/(double) MB_SIZE + " MB.");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("Dumped the whole data structure to file " + this._filePathName);
    }

}
