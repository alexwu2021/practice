## how to run it


1. under ${user.name}, create a folder called kafka

2. grab kafka 2.1.2 tar.gz file

3. unzip it, rename it as k212, move it to ${user.name}/kafka

4. change group.id in the file  ${user.name}/kafka/k212/config/consumer.properties, making sure it look like

group.id=DMAppDwFeedEvent

5. sudo sh z.sh   ==> launch zookeeper

6. sudo sh k.sh  ==> launch kafka

7. sh prod.sh  ==> launch the producer

8. sh cons.sh  ==> launch the consumer



## how to clean up

1. sudo sh clean.sh  => it will delete the whole kafka logs folder, and the whole zookeeper folder



## how to ensure ports be released
sudo lsof -ti:${port you want to check}
sudo kill -9  ${the process that hogs the port}