
echo "starting producer"
cd k212
bin/kafka-console-producer.sh --topic topic-dw-feed-event --broker-list localhost:9092


