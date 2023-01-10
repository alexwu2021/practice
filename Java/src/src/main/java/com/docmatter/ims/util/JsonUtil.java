package com.docmatter.ims.util;

import com.docmatter.ims.domain.model.TopicDwFeedEventPayload;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    public static String toJson(Object cat){
        String retJson = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            retJson = mapper.writeValueAsString(cat);
            System.out.println("Resulting JSON string = " + retJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return retJson;
    }

    public static TopicDwFeedEventPayload fromJson(String json){
        TopicDwFeedEventPayload topicDwFeedEventPayload = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            topicDwFeedEventPayload = mapper.readValue(json, TopicDwFeedEventPayload.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return topicDwFeedEventPayload;
    }
}
