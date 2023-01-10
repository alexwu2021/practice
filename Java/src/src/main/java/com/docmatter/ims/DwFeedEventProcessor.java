package com.docmatter.ims;

import com.docmatter.ims.service.kafka.DwFeedEventStoringFacility;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.*;

@Component
public class DwFeedEventProcessor extends TimerTask {

    private static final Logger log = LoggerFactory.getLogger(DwFeedEventProcessor.class);

    private static final int NUMBER_OF_MS_FOR_NEXT_FULL_RUN = 10 * 1000;
    private static final int CONSUMER_PULLING_INTERVAL = 2 * 1000;
    private final static String KAFKA_TOPIC_ID = "topic-dw-feed-event";
    private final static String KAFKA_GROUP_ID = "DMAppDwFeedEvent";


    @Autowired
    private DwFeedEventStoringFacility dwFeedEventStoringFacility;

    @Value("${app.debugMode}")
    private boolean debugMode;

    @Value("${appConfig.KafkaServers}")
    private String KAFKA_SERVERS;

    public DwFeedEventProcessor() throws FileNotFoundException {
        Timer timer = new Timer();
        int period = NUMBER_OF_MS_FOR_NEXT_FULL_RUN;
        period = Integer.MAX_VALUE;

        Calendar currentTimeNow = Calendar.getInstance();
        currentTimeNow.add(Calendar.SECOND, 3);
        timer.scheduleAtFixedRate(this, currentTimeNow.getTime(), period);
//        System.out.println("simulating handling of streaming event data");
//        KafkaSim kafkaSim1 = new KafkaSim(1);
//        new Thread(kafkaSim1).start();
    }

    public void run() {
        System.out.println("\n[===timer task triggered");
//        try {
            System.out.println("no op since we are relying on kafka streaming service");

//            if(debugMode){
//                System.out.println("to run polling based kafka consumer");
//                runConsumer();
//            }else{
//                System.out.println("no op, will not run the polling based kafka consumer");
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//       }
        System.out.println("===timer task done]\n\n");
    }

//    private Consumer<String, String>createStringBasedConsumer(){
//        DefaultKafkaConsumerFactory<String, String> consumerFactory =
//                new DefaultKafkaConsumerFactory<String, String>(consumerProperties,
//                        new StringDeserializer(), new StringDeserializer());
//    }

    private Consumer<String, String> createConsumer() {
        System.out.println("entering createConsumer");
        if(KAFKA_SERVERS == null || KAFKA_SERVERS.length() <= 0) {
            System.out.println("no op exiting createConsumer");
            return null;
        }


        final Properties props = new Properties();
        System.out.println("BOOTSTRAP_SERVERS_CONFIG is going to be set as " + KAFKA_SERVERS);
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_SERVERS);

        System.out.println("GROUP_ID_CONFIG is going to be set as " + KAFKA_GROUP_ID);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, KAFKA_GROUP_ID);

        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        // Create the consumer using props.
        final Consumer<String, String> consumer = new KafkaConsumer<>(props);

        // Subscribe to the topic.
        System.out.println("KAFKA_TOPIC_ID is going to be set as " + KAFKA_TOPIC_ID);
        consumer.subscribe(Collections.singletonList(KAFKA_TOPIC_ID));
        System.out.println("exiting from createConsumer");
        return consumer;
    }

    private void runConsumer() throws InterruptedException {
        System.out.println("run consumer ...");

        final Consumer<String, String> consumer = createConsumer();
        if(consumer == null){
            return;
        }

        final long maxNumRetryCount = 100000000L;
        long retryCount = 0;
        while (true) {
            final ConsumerRecords<String, String> consumerRecords = consumer.poll(CONSUMER_PULLING_INTERVAL);
            if (consumerRecords.count()==0) {
                System.out.println("pulled nothing back, will retry on the " + retryCount + "th retry.");
                retryCount++;
                if (retryCount > maxNumRetryCount) break;
                else continue;
            }

            System.out.println(String.format("size of consumerRecords: %d", consumerRecords.count()));
            System.out.println(String.format("the first of consumerRecords: %s", consumerRecords.iterator().next().toString()));

            consumerRecords.forEach(record -> {
                System.out.printf("Consumer Record:(%s, %s, %d, %d)\n",
                        record.key(), record.value(),
                        record.partition(), record.offset());

                saveToDwTables(record.value());
            });
            consumer.commitAsync();
        }
        consumer.close();
        System.out.println("runConsumer is done");
    }

    public void saveToDwTables(String jsonString) {
      this.dwFeedEventStoringFacility.saveToDwTables(jsonString);
    }

}


