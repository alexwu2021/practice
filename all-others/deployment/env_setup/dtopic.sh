echo "to delete the topic 'topic-dw-feed-event'"

cd k212
bin/kafka-topics.sh --delete --topic topic-dw-feed-event  --bootstrap-server localhost:9092


