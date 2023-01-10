package com.docmatter.testclient;

import com.docmatter.ims.constant.ImsConstant;
import com.docmatter.ims.util.JsonUtil;
import com.docmatter.ims.domain.model.TopicDwFeedEventPayload;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TopicDwFeedEventPayloadFactory {

    public static TopicDwFeedEventPayload generateOneRandomEmailOpenFeedEventPayload() {
        String jsonString = "{\"event_type\":\"email-open\",\"uid\":119224,\"noti_id\":1632788,\"noti_email_id\":17894249,\"category\":\"Post\",\"open_date\":1609467497000,\"user_state\":1,\"date\":1643835734239,\"discussion_thread_id_list\":[72178],\"post_id_list\":[72178],\"post_author_list\":[73548],\"user_cid_list\":[80771,20011091,30011401,60010904],\"discussion_cid_list\":[30011401]}";
        String jsonString2 = "{\"event_type\":\"email-open\",\"uid\":101726,\"noti_id\":1638152,\"noti_email_id\":17977675,\"category\":\"Post\",\"open_date\":1609830194000,\"user_state\":1,\"date\":1643839898338,\"discussion_thread_id_list\":[66407],\"post_id_list\":[66407],\"post_author_list\":[137774],\"user_cid_list\":[60011110,40011620,400012030,400012150],\"discussion_cid_list\":[40011620]}";
        String jsonString3 = "{\"event_type\":\"email-open\",\"uid\":146432,\"noti_id\":1642347,\"noti_email_id\":18049939,\"category\":\"Response\",\"open_date\":1610021967000,\"user_state\":1,\"date\":1643842137190,\"discussion_thread_id_list\":[72273],\"post_id_list\":[72492],\"post_author_list\":[146432],\"user_cid_list\":[60010934,60010959,400011880],\"discussion_cid_list\":[400011880]}";
        Random random = new Random(System.currentTimeMillis());
        if (random.nextInt() % 3 == 1){
            return JsonUtil.fromJson(jsonString);
        }else if (random.nextInt() % 3 == 2){
            return JsonUtil.fromJson(jsonString2);
        }
        return JsonUtil.fromJson(jsonString3);
    }

    public static List<TopicDwFeedEventPayload> getFromFile() throws IOException {
        List<TopicDwFeedEventPayload> ret = new ArrayList<>();
        String filePathName = ImsConstant.PAY_LOAD_DATA_FILE;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePathName));
        String line = bufferedReader.readLine();
        int lineCount = 0;
        while(line != null && line.length() > 0){
            lineCount++;
            TopicDwFeedEventPayload topicDwFeedEventPayload = JsonUtil.fromJson(line);
            if(topicDwFeedEventPayload != null){

                ret.add(topicDwFeedEventPayload);
            }
            if(lineCount % 10000 == 0){
                System.out.println("processing line " + lineCount + " for retrieving TopicDwFeedEventPayload objects");
            }
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return ret;
    }
}
