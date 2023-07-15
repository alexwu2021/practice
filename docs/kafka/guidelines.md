## main sources: https://kafka.apache.org/quickstart
1. install kafka

2. Start zookepper
      sudo bin/zookeeper-server-start.sh config/zookeeper.properties

3. Start kafka
      sudo bin/kafka-server-start.sh config/server.properties


4. Create topic
[//]: # (         bin/kafka-topics.sh –-create --zookeeper localhost:2181 --partitions 1 --replication-factor 1 --topic topic-dw-feed-event)

bin/kafka-topics.sh --create  --zookeeper localhost:2181  --topic topic-dw-feed-event --bootstrap-server localhost:9092 --replication-factor 1 --partitions 4



5. List the topics
[//]: # (      bin/kafka-topics.sh --list --zookeeper localhost:2181  )
the following works:

bin/kafka-topics.sh --list --bootstrap-server localhost:9092


this also works:
bin/kafka-topics.sh --describe --topic topic-dw-feed-event --bootstrap-server localhost:9092


7. Create producers

[//]: # (bin/kafka-console-producer.sh --broker-list localhost:9092 --topic topic-dw-feed-event)
bin/kafka-console-producer.sh --topic topic-dw-feed-event --bootstrap-server localhost:9092

then type something and end it by typing control c

7.	Create consumers

[//]: # (bin/kafka-console-consumer.sh --bootstrap-server localhost:9093 --topic pubmed-xml --from-beginning)

[//]: # ([//]: # (bin/kafka-console-consumer.sh --bootstrap-server localhost:9094 --topic pubmed-xml-element --from-beginning)
bin/kafka-console-consumer.sh --topic topic-dw-feed-event --from-beginning --bootstrap-server localhost:9092


8.	Delete topic
bin/kafka-topics.sh --delete --topic topic-dw-feed-event --zookeeper localhost:2181

[//]: # ()
[//]: # (bin/kafka-topics.sh --delete --topic pubmed-xml-author --zookeeper localhost:2181)
for this to be operatable, we need add this line to config/server.properties

delete.topic.enable=true
and restart the kafka


bin/kafka-topics.sh –delete –zookeeper localhost:2181 –topic topic-dw-feed-event


modify config/consumer.properties to add the required consumer group id DMAppDwFeedEvent



=========
https://stackoverflow.com/questions/33537950/how-to-delete-a-topic-in-apache-kafka
Follow this step by step process for manual deletion of topics

1. Stop Kafka server
2. Delete the topic directory, on each broker (as defined in the logs.dirs and log.dir properties) with rm -rf command
3. Connect to Zookeeper instance: zookeeper-shell.sh host:port
     From within the Zookeeper instance: List the topics using: ls /brokers/topics 
     Remove the topic folder from ZooKeeper using: deleteall /brokers/topics/yourtopic  
4. Exit the Zookeeper instance (Ctrl+C)
5. Restart Kafka server
Confirm if it was deleted or not by using this command kafka-topics.sh --list --zookeeper host:port

6. Lag
      sudo bin/kafka-run-class.sh kafka.admin.ConsumerGroupCommand --bootstrap-server localhost:9092 --describe --group group_name

7. delete data and events
   rm -rf /tmp/kafka-logs /tmp/zookeeper





10. Manually remove the data from Kafka logs.
   As I specified in the beginning, Kafka stores all messages in logs in their respective nodes at the location 
11. specified in log.dir. We should remove all these messages for a topic from all nodes. Below are the steps to remove.

Stop zookeeper and Kafka broker from all nodes.
Clean logs from all nodes. it stores log files at /tmp/kafka-logs/MyTopic-0 where /tmp/kafka-logs is specified by 
the log.dir attribute Restart zookeeper and broker from all nodes.
