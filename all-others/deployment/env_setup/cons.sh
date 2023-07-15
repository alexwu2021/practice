echo "starting consumer"
cd k212

bin/kafka-console-consumer.sh  --bootstrap-server localhost:9092 --topic topic-dw-feed-event --from-beginning

