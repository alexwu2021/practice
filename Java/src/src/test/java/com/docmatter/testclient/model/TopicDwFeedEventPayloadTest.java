package com.docmatter.testclient.model;

import com.docmatter.ims.domain.model.TopicDwFeedEventPayload;
import com.docmatter.testclient.TopicDwFeedEventPayloadFactory;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.text.ParseException;

class TopicDwFeedEventPayloadTest {

    @Test
    void toJson() throws ParseException {
        TopicDwFeedEventPayload topicDwFeedEventPayload = TopicDwFeedEventPayloadFactory.generateOneRandomEmailOpenFeedEventPayload();
        String result = topicDwFeedEventPayload.toJson();
        Assert.isTrue(result != null && result.length() > 0);

        Assert.isTrue(result.indexOf("category") > 0);
        Assert.isTrue(result.indexOf("discussion") > 0);
        Assert.isTrue(result.indexOf("user") > 0);
        Assert.isTrue(result.indexOf("date") > 0);
        Assert.isTrue(result.indexOf("email") > 0);

    }
}