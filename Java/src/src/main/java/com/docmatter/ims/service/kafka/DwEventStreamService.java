/**
 * Copyright (c) 2015 DocMatter, Inc.
 * All rights reserved.
 *  
 */
package com.docmatter.ims.service.kafka;


import com.fasterxml.jackson.databind.JsonNode;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.connect.json.JsonDeserializer;
import org.apache.kafka.connect.json.JsonSerializer;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Properties;

/**
 * Kafka streaming service when a link in notification email is clicked
 * 
 *
 *
 */
@Service
public class DwEventStreamService extends BaseStreamService {

    private static final Logger logger = LoggerFactory.getLogger(DwEventStreamService.class);
    public static final String KAFKA_STREAMING_APPID_DW_FEED_AS_GROUP_ID = "DMAppDwFeedEvent";
    public static final String KAFKA_TOPIC_DW_FEED = "topic-dw-feed-event";

    private String KAFKA_SERVERS;
    private DwFeedEventStoringFacility dwFeedEventStoringFacility;

    @Autowired
    public DwEventStreamService(DwFeedEventStoringFacility dwFeedEventStoringFacility) {
        super();
        try{
            this.dwFeedEventStoringFacility = dwFeedEventStoringFacility;
            if(dwFeedEventStoringFacility != null){
                KAFKA_SERVERS = dwFeedEventStoringFacility.KAFKA_SERVERS;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private DwEventStreamService(){
        System.out.println("DwEventStreamService default constructor");
    }


     
    /**
     * Execute streaming service.
     */
    @Override
    protected void execute() {
        try {
            System.out.println("in execute of DwEventStreamService");
            if(this.dwFeedEventStoringFacility == null){
                System.out.println("dwFeedEventStoringFacility is null");



            }else{
                System.out.println("dwFeedEventStoringFacility is not null");
            }

            final String hosts = KAFKA_SERVERS; //ConfigManager.getInstance().getConfig("kafka", "kafka.cluster.hosts.v2");
            System.out.println("DwEventStreamService, bootstrap hosts are " + hosts);
            final Serializer<JsonNode> jsonSerializer = new JsonSerializer();
            final Deserializer<JsonNode> jsonDeserializer = new JsonDeserializer();
            final Serde<JsonNode> jsonSerde = Serdes.serdeFrom(jsonSerializer, jsonDeserializer);
            final Properties props = new Properties();
            props.put(StreamsConfig.APPLICATION_ID_CONFIG, KAFKA_STREAMING_APPID_DW_FEED_AS_GROUP_ID); // this will be used as group ID as well
            props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, hosts);
            props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
            props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
            props.put(StreamsConfig.PROCESSING_GUARANTEE_CONFIG, StreamsConfig.EXACTLY_ONCE);

            final StreamsBuilder builder = new StreamsBuilder();
            final KStream<String, JsonNode> data = builder.stream(KAFKA_TOPIC_DW_FEED, Consumed.with(Serdes.String(), jsonSerde));
            data.foreach((k, v) -> processRequest(KAFKA_TOPIC_DW_FEED, k, v)); // end of the stream, to sink
            final Topology topology = builder.build();
            serviceStreams = new KafkaStreams(topology, props);
            serviceStreams.cleanUp();
            serviceStreams.start();
            System.out.println("in execute after start before await");
            serviceLatch.await();
        } catch (final Throwable e) {
            // TODO: restart service ?
            //logger.error("in execute dw event streaming service terminated unexpectedly, ", e);
            System.out.println(String.format("in execute dw event streaming service terminated unexpectedly, e=%s ", e));
        }
        System.out.println("exiting execute of DwEventStreamService");
    }

    private void processRequest(String topic, final String key, final JsonNode json) {
        System.out.println("in processRequest(), key " + key + ", json: " + json);
        // validate event data
        if (json == null || json.toString().length() <= 0) {
            System.err.println("invalid request");
            return;
        }

        // process event
        try {
            String jsonString = json.toString();
            System.out.println("processRequest, jsonString: " + jsonString);
            if(dwFeedEventStoringFacility != null){
                dwFeedEventStoringFacility.saveToDwTables(jsonString);
            }else{
                System.out.println("!!dwFeedEventStoringFacility is null");
            }
        } catch (final Exception ex) {
            // swallow exception: consumer failed, log in DB (in new session and transaction) for manual processing
            //logger.error("exception encountered in processRequest", ex);
            System.err.println(String.format("exception encountered in processRequest ex=%s", ex));
            //KafkaFailureLogManager.getInstance().logConsumerError(topic, key, (json != null ? json.toString() : ""), ex.getMessage(), null);
        }
    }

}
