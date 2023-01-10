package com.docmatter.ims.kafka;


import com.docmatter.ims.EventDataProcessor;
import com.docmatter.ims.domain.model.LogNotificationEmailView;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.Thread.sleep;

public class KafkaSim implements Runnable {
    public static Map<Integer, LogNotificationEmailViewContext> threadIdToContext = new ConcurrentHashMap<>();
    private  int id;
    public KafkaSim(int id) throws FileNotFoundException {
        LogNotificationEmailViewContext context = new LogNotificationEmailViewContext(this.id);
        this.id = id;
        threadIdToContext.put(this.id, context);
    }


    @Override
    public void run() {
        Random random = new Random(System.currentTimeMillis());
        int count = 0, maxCount = 1000;
        do{
            count++;
            try {
                LogNotificationEmailViewContext context = threadIdToContext.get(this.id);
                if(context != null && context.getOne() != null){
                    LogNotificationEmailView logNotificationEmailView = context.getOne();
                    System.out.println("received kafka event date [ " + logNotificationEmailView.toString() + "]");
                    EventDataProcessor.me().processingEventData(logNotificationEmailView);
                }else{
                    System.out.println("kafka event date something went wrong");
                }
                int msToSleep = (1 + random.nextInt(15)) * 1000;
                sleep(msToSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while(true && count < maxCount);
    }

}