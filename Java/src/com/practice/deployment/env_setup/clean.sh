echo "to clean zookeeper and kafka folders and logs, to back up the web app log before deleting it "

sudo rm -rf /tmp/kafka-logs/
echo "kafka logs deleted"


sudo rm -rf /tmp/zookeeper/
echo "zookeeper folder deleted"
ß
echo "now this is the content under /tmp/ "
sudo ls /tmp/

sudo cp -f /opt/tomcat/latest/webapplogs/poc-mp/ims.log  /opt/tomcat/latest/webapplogs/poc-mp/ims.old.log
sudo rm -f /opt/tomcat/latest/webapplogs/poc-mp/ims.log

echo "the web app log backed up"

