package com.docmatter.ims.kafka;

import com.docmatter.ims.constant.ImsConstant;
import com.docmatter.ims.domain.model.LogNotificationEmailView;
import com.docmatter.ims.util.FileUtil;
//import com.docmatter.util.StringUtil;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LogNotificationEmailViewContext {
    private Integer id;
    private String fileName = FileUtil.getAbsoluteFilePath(ImsConstant.LOG_NOTIFICATION_EMAIL_VIEW_INPUT_FILE);
    private int capacity;
    private List<LogNotificationEmailView> kafkaPackets;

    /**
     * @param id
     *
     *  the fields:
        emailToUid     // 0
        viewDate  // 1
        notificationEmailId // 2
        category  // 3
        notificationId;  // 4
     *  the instances
     * 10010,20211004,28009143,Daily Digest,2343434
     * 10010,20211006,28146714,Newsletter-IARS,2350831
     */
    public LogNotificationEmailViewContext(int id) throws FileNotFoundException {
        this.id = id;
        this.capacity = 10000;
        kafkaPackets = new ArrayList<>();
        try {
            int lineCount = 0;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.fileName));
            String line = bufferedReader.readLine();
            while (line !=null && line.length() > 0  && lineCount < capacity) {
                String[] sa = line.split(ImsConstant.SPLITTER);
                LogNotificationEmailView temp = new LogNotificationEmailView();
                temp.setEmailToUid(Integer.valueOf(sa[0]));
                temp.setViewDate(sa[1]);
                temp.setNotificationEmailId(Integer.valueOf(sa[2]));
                temp.setCategory(sa[3]);
                temp.setNotificationId(Integer.valueOf(sa[4]));

                kafkaPackets.add(temp);
                lineCount++;
                if(lineCount % 1000 == 0){
                    System.out.println("in LogNotificationEmailViewContext, lineCount: " + lineCount);
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("NotificationCtxMessageContext(), finished construction");
        }
    }

    @PostConstruct
    public LogNotificationEmailView getOne(){
        Random random = new Random(System.currentTimeMillis());
        int index = random.nextInt(10000) % this.capacity;
        if(this.kafkaPackets.size() -1 > index)
            return this.kafkaPackets.get(index);
        return null;
    }

}
