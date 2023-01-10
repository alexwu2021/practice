echo "to create the designated topic 'topic-dw-feed-event'"

cd k212

bin/kafka-topics.sh --create   --topic topic-dw-feed-event --bootstrap-server localhost:9092 --replication-factor 1 --partitions 4


