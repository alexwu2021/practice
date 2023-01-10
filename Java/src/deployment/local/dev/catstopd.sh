echo "stopping dev version tomcat and cleaning up the logs"

/Users/Alex/tomcat/apache-tomcat-9.0.58/bin/shutdown_debug.sh

cp -f /Users/Alex/tomcat/apache-tomcat-9.0.58/logs/catalina.out   /Users/Alex/tomcat/apache-tomcat-9.0.58/logs/catalina.old.out

rm -f /Users/Alex/tomcat/apache-tomcat-9.0.58/logs/catalina.out