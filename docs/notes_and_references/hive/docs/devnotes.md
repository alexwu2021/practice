## web console:
hive and hadoop job board can be found here: http://localhost:8088/cluster/


## health checking script:
hadoop jar /usr/local/Cellar/hadoop/3.3.1/libexec/share/hadoop/mapreduce/hadoop-mapreduce-examples-3.3.1.jar pi 2 5


## component checking cmd: jps


## first command to ship out: ssh localhost

## two sh files:
/usr/local/Cellar/hadoop/3.3.1/sbin/start-all.sh
/usr/local/Cellar/hadoop/3.3.1/sbin/stop-all.sh

## in case of connection refusal, run those two sh files: stop all and then start all



## rules to following in authoring hql statement:
for joins, we can only use * in the select clause if all the underlying tables have the same structure/columns;
either wise, we need specify all the columns to return, and we should not use * in the select caluse.

## sample hql queries

## joins

-- this one return data but no reducer
select m.msid, m.THREAD_MSID, pc.ctxtype, pc.ctxid, pc.created_by from ctxmessage m inner join post_comm pc on m.msid = pc.msid;

-- this one will trigger 1 reducer, and expected to show
tage-Stage-2: Map: 1  Reduce: 1   HDFS Read: 51577 HDFS Write: 129 SUCCESS
Total MapReduce CPU Time Spent: 0 msec
OK
10000	80
10010	80

select m.msid as MSID, count(*) as COUNT from ctxmessage m inner join post_comm pc on m.msid = pc.msid group by m.msid having count(*) > 0;


-- return no data
select e.name, pc.msid from ctxentity e inner join post_comm pc on e.ctxid = pc.ctxid and e.ctxtype = pc.ctxtype ;


## useful page:
https://community.cloudera.com/t5/Support-Questions/ALL-hadoop-mapreduce-examples-jar-fail-cdh6/td-p/290558/page/2

as for logs,
yarn logs -applicationId application_1582677468069_0009 > application_1582677468069_0009.log
this will show all the logs for this application including any information that may have been missing from the job stdout.


## trouble shooting for
FAILED: Execution Error, return code 2 from org.apache.hadoop.hive.ql.exec.MapRedTask
use the web console to dig deeper and collect more info, in general, changing the mapred-site.xml and other configuration files if needed would fix this issue.



## trouble shooting for
Diagnostic Messages for this Task:
Container launch failed for container_1639440893348_0020_01_000005 : org.apache.hadoop.yarn.exceptions.InvalidAuxServiceException: The auxService:mapreduce_shuffle does not exist
	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
	at org.apache.hadoop.yarn.api.records.impl.pb.SerializedExceptionPBImpl.instantiateExceptionImpl(SerializedExceptionPBImpl.java:171)
	at org.apache.hadoop.yarn.api.records.impl.pb.SerializedExceptionPBImpl.instantiateException(SerializedExceptionPBImpl.java:182)
	at org.apache.hadoop.yarn.api.records.impl.pb.SerializedExceptionPBImpl.deSerialize(SerializedExceptionPBImpl.java:106)
	at org.apache.hadoop.mapreduce.v2.app.launcher.ContainerLauncherImpl$Container.launch(ContainerLauncherImpl.java:163)
	at org.apache.hadoop.mapreduce.v2.app.launcher.ContainerLauncherImpl$EventProcessor.run(ContainerLauncherImpl.java:394)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at java.lang.Thread.run(Thread.java:748)



## checking hive version
hive > select version();
OK
3.1.2 r8190d2be7b7165effa62bd21b7d60ef81fb0e4af


## ref

Hive Connection Url
Hive Connection URL have the following format :
jdbc:hive2://<hiveserver>:10000/;ssl=false
Default port is 10000.

Init Connection
private static final String JDBC_DRIVER_NAME = "org.apache.hive.jdbc.HiveDriver";
// Set JDBC Hive Driver
Class.forName(JDBC_DRIVER_NAME);
// Connect to Hive
// Choose a user that has the rights to write into /user/hive/warehouse/
(e.g. hdfs)
con = DriverManager.getConnection(connectionUrl,"hdfs","");
// OR your user/password
con = DriverManager.getConnection(connectionUrl,user,password);
// Init Statement
Statement stmt = con.createStatement();
How to create a Hive table
String sqlStatementDrop = "DROP TABLE IF EXISTS helloworld";
String sqlStatementCreate = "CREATE TABLE helloworld (message String)
STORED AS PARQUET";
// Execute DROP TABLE Query
stmt.execute(sqlStatementDrop);
// Execute CREATE Query
stmt.execute(sqlStatementCreate);
How to insert data into a Hive table
String sqlStatementInsert = "INSERT INTO helloworld VALUES (\"helloworld\")";
// Execute INSERT Query
stmt.execute(sqlStatementInsert);
How to select data from a Hive table
String sqlStatementSelect = "SELECT * from helloworld";
// Execute SELECT Query
ResultSet rs = stmt.executeQuery(sqlStatementSelect);
// Process results
while(rs.next()) {
logger.info(rs.getString(1));
}
 
## on how to restart hive server
cd /usr/local/Cellar/hive/3.1.2_3/libexec/bin
./hiveserver2

or

/usr/local/Cellar/hive/3.1.2_3/libexec/bin/hiveserver2


## trouble shooting not allowing impersonating

Caused by: java.lang.RuntimeException: org.apache.hadoop.ipc.RemoteException(org.apache.hadoop.security.authorize.AuthorizationException): User: Alex is not allowed to impersonate hive
at org.apache.hadoop.hive.ql.session.SessionState.start(SessionState.java:651)
at org.apache.hadoop.hive.ql.session.SessionState.start(SessionState.java:586)
at org.apache.hive.service.cli.session.HiveSessionImpl.open(HiveSessionImpl.java:179)
at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
at java.lang.reflect.Method.invoke(Method.java:498)
at org.apache.hive.service.cli.session.HiveSessionProxy.invoke(HiveSessionProxy.java:78)
... 21 more

this is the answer I am going to adopt: https://github.com/chuqbach/Big-Data-Installation/issues/3
Add the following to Hive hive-site.xml

  <property>
    <name>hive.server2.enable.doAs</name>
    <value>false</value>
  </property>

Or this one to Hadoop core-site.xml

  <property>
    <name>hadoop.proxyuser.server.hosts</name> 
    <value>*</value> 
  </property> 
  <property>
    <name>hadoop.proxyuser.server.groups</name>

    <value>*</value>
  </property>



## about checking connections with hive.metastore.uris

hive> set hive.metastore.uris;
hive.metastore.uris=thrift://sandbox.hortonworks.com:9083






This is Joelle So from KCAL Insurance agency. Our mutual client is ALEX MING WU
and his loan number is 8200450423. He said he received a letter stating his 
insurance is not sufficient. Could you please provide the required amount so I can update the coverage for him? Attached below is the letter I mentioned. Thank you so much!

 

 ## alert: reinstalling hive could lead to


Error: Table 'ctlgs' already exists (state=42S01,code=1050)
org.apache.hadoop.hive.metastore.HiveMetaException: Schema initialization FAILED! Metastore state would be inconsistent !!
Underlying cause: java.io.IOException : Schema script failed, errorcode 2
Use --verbose for detailed stacktrace.


i dropped the hive database then it got resolved

now hive has two: hive and metastore databases in mysql





## about the warning of Metadata has jdbc-type of null

2021-12-17 10:26:28,795 INFO DataNucleus.Persistence: Property datanucleus.cache.level2 unknown - will be ignored
2021-12-17 10:26:30,110 WARN DataNucleus.MetaData: Metadata has jdbc-type of null yet this is not valid. Ignored
2021-12-17 10:26:30,111 WARN DataNucleus.MetaData: Metadata has jdbc-type of null yet this is not valid. Ignored
2021-12-17 10:26:30,112 WARN DataNucleus.MetaData: Metadata has jdbc-type of null yet this is not valid. Ignored
2021-12-17 10:26:30,112 WARN DataNucleus.MetaData: Metadata has jdbc-type of null yet this is not valid. Ignored
2021-12-17 10:26:30,113 WARN DataNucleus.MetaData: Metadata has jdbc-type of null yet this is not valid. Ignored
2021-12-17 10:26:30,113 WARN DataNucleus.MetaData: Metadata has jdbc-type of null yet this is not valid. Ignored
2021-12-17 10:26:31,366 WARN DataNucleus.MetaData: Metadata has jdbc-type of null yet this is not valid. Ignored
2021-12-17 10:26:31,366 WARN DataNucleus.MetaData: Metadata has jdbc-type of null yet this is not valid. Ignored
2021-12-17 10:26:31,367 WARN DataNucleus.MetaData: Metadata has jdbc-type of null yet this is not valid. Ignored
2021-12-17 10:26:31,367 WARN DataNucleus.MetaData: Metadata has jdbc-type of null yet this is not valid. Ignored
2021-12-17 10:26:31,367 WARN DataNucleus.MetaData: Metadata has jdbc-type of null yet this is not valid. Ignored
2021-12-17 10:26:31,367 WARN DataNucleus.MetaData: Metadata has jdbc-type of null yet this is not valid. Ignored

someone posted this at https://stackoverflow.com/questions/51996755/hive-3-1-metastore-error-on-startup-connecting-to-mysql-rds 
https://issues.apache.org/jira/browse/HIVE-19740 After setting hive.metastore.event.db.notification.api.auth to false on hive-site.xml. Hive can start and function normally.

but it seems it didn't resolve the issue above


## configuration of hiveserver2-site.xml
from hive-site.xml ?




## study of the key hive.metastore.warehouse.dir
apparent hive-site.xml has it
now my configuration as fo now is
<name>hive.metastore.warehouse.dir</name>
<value>hdfs://localhost:9000/user/hive/warehouse</value>
</property>

this article
https://jaceklaskowski.gitbooks.io/mastering-spark-sql/content/spark-sql-hive-metastore.html
suggests


<configuration>
  <property>
    <name>hive.metastore.warehouse.dir</name>
    <value>/tmp/hive-warehouse</value>
    <description>Hive Metastore location</description>
  </property>
</configuration>

but where is /tmp? is this one: /usr/local/Cellar/hadoop/hdfs/tmp?


## the working way
Last login: Fri Dec 17 15:53:59 on ttys000
Alex@mp-2020-5 ~ % /usr/local/Cellar/hive/3.1.2_3/libexec/bin/beeline    
SLF4J: Class path contains multiple SLF4J bindings.
SLF4J: Found binding in [jar:file:/usr/local/Cellar/hive/3.1.2_3/libexec/lib/log4j-slf4j-impl-2.10.0.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:/usr/local/Cellar/hadoop/3.3.1/libexec/share/hadoop/common/lib/slf4j-log4j12-1.7.30.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
SLF4J: Actual binding is of type [org.apache.logging.slf4j.Log4jLoggerFactory]
Beeline version 3.1.2 by Apache Hive
beeline> !connect jdbc:hive2://
Connecting to jdbc:hive2://
Enter username for jdbc:hive2://: hive
Enter password for jdbc:hive2://: ***********
21/12/17 16:03:00 [main]: WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
Hive Session ID = 771037da-a075-41ca-908a-f11e6d869a89
21/12/17 16:03:01 [main]: WARN session.SessionState: METASTORE_FILTER_HOOK will be ignored, since hive.security.authorization.manager is set to instance of HiveAuthorizerFactory.
21/12/17 16:03:01 [main]: WARN metastore.ObjectStore: datanucleus.autoStartMechanismMode is set to unsupported value null . Setting it to value: ignored
21/12/17 16:03:03 [main]: WARN DataNucleus.MetaData: Metadata has jdbc-type of null yet this is not valid. Ignored
21/12/17 16:03:03 [main]: WARN DataNucleus.MetaData: Metadata has jdbc-type of null yet this is not valid. Ignored
21/12/17 16:03:03 [main]: WARN DataNucleus.MetaData: Metadata has jdbc-type of null yet this is not valid. Ignored
21/12/17 16:03:03 [main]: WARN DataNucleus.MetaData: Metadata has jdbc-type of null yet this is not valid. Ignored
21/12/17 16:03:03 [main]: WARN DataNucleus.MetaData: Metadata has jdbc-type of null yet this is not valid. Ignored
21/12/17 16:03:03 [main]: WARN DataNucleus.MetaData: Metadata has jdbc-type of null yet this is not valid. Ignored
21/12/17 16:03:04 [main]: WARN DataNucleus.MetaData: Metadata has jdbc-type of null yet this is not valid. Ignored
21/12/17 16:03:04 [main]: WARN DataNucleus.MetaData: Metadata has jdbc-type of null yet this is not valid. Ignored
21/12/17 16:03:04 [main]: WARN DataNucleus.MetaData: Metadata has jdbc-type of null yet this is not valid. Ignored
21/12/17 16:03:04 [main]: WARN DataNucleus.MetaData: Metadata has jdbc-type of null yet this is not valid. Ignored
21/12/17 16:03:04 [main]: WARN DataNucleus.MetaData: Metadata has jdbc-type of null yet this is not valid. Ignored
21/12/17 16:03:04 [main]: WARN DataNucleus.MetaData: Metadata has jdbc-type of null yet this is not valid. Ignored
Connected to: Apache Hive (version 3.1.2)
Driver: Hive JDBC (version 3.1.2)
Transaction isolation: TRANSACTION_REPEATABLE_READ
0: jdbc:hive2://> show databases;
OK
+----------------+
| database_name  |
+----------------+
| default        |
+----------------+
1 row selected (1.21 seconds)
0: jdbc:hive2://> use default;
OK
No rows affected (0.068 seconds)
0: jdbc:hive2://> create table test1 (id INT) ;
OK
No rows affected (0.625 seconds)
0: jdbc:hive2://> show tables;
OK
+-----------+
| tab_name  |
+-----------+
| test1     |
+-----------+
1 row selected (0.067 seconds)
0: jdbc:hive2://> select * from test1;
OK
+-----------+
| test1.id  |
+-----------+
+-----------+
No rows selected (1.471 seconds)



## issues with M1 Big Sure

Alex@docmatters-mbp ~ % brew install hive
==> Homebrew is run entirely by unpaid volunteers. Please consider donating:
https://github.com/Homebrew/brew#donations
==> Auto-updated Homebrew!
Updated 1 tap (homebrew/core).
==> Updated Formulae
Updated 1 formula.

==> Downloading https://ghcr.io/v2/homebrew/core/m4/manifests/1.4.19
######################################################################## 100.0%
==> Downloading https://ghcr.io/v2/homebrew/core/m4/blobs/sha256:ea1be04e51645f9e31c8d2cab6d144bb7f47efb1f35214b9f1014e27db5a3bc1
==> Downloading from https://pkg-containers.githubusercontent.com/ghcr1/blobs/sha256:ea1be04e51645f9e31c8d2cab6d144bb7f47efb1f35214b9f1014e27db5a3bc1
######################################################################## 100.0%
==> Downloading https://ghcr.io/v2/homebrew/core/autoconf/manifests/2.71
######################################################################## 100.0%
==> Downloading https://ghcr.io/v2/homebrew/core/autoconf/blobs/sha256:6279cc6294da77a87b2e08783f39a97e8678bde9b3e2899685879cabee6d2945
==> Downloading from https://pkg-containers.githubusercontent.com/ghcr1/blobs/sha256:6279cc6294da77a87b2e08783f39a97e8678bde9b3e2899685879cabee6d2945
######################################################################## 100.0%
==> Downloading https://ghcr.io/v2/homebrew/core/pkg-config/manifests/0.29.2_3
######################################################################## 100.0%
==> Downloading https://ghcr.io/v2/homebrew/core/pkg-config/blobs/sha256:ffd4491f62201d14b7eca6beff954a2ab265351589cd5b3b79b8bbb414485574
==> Downloading from https://pkg-containers.githubusercontent.com/ghcr1/blobs/sha256:ffd4491f62201d14b7eca6beff954a2ab265351589cd5b3b79b8bbb414485574
######################################################################## 100.0%
==> Downloading https://ghcr.io/v2/homebrew/core/libpng/manifests/1.6.37
######################################################################## 100.0%
==> Downloading https://ghcr.io/v2/homebrew/core/libpng/blobs/sha256:766a7136ee626b411fb63da0c7e5bc1e848afb6e224622f25ea305b2d1a4a0f1
==> Downloading from https://pkg-containers.githubusercontent.com/ghcr1/blobs/sha256:766a7136ee626b411fb63da0c7e5bc1e848afb6e224622f25ea305b2d1a4a0f1
######################################################################## 100.0%
==> Downloading https://ghcr.io/v2/homebrew/core/freetype/manifests/2.11.1
######################################################################## 100.0%
==> Downloading https://ghcr.io/v2/homebrew/core/freetype/blobs/sha256:7621db36f0e51ae0bb9094d56ae5462fbf249969aff225555c1e5845fe7477c1
==> Downloading from https://pkg-containers.githubusercontent.com/ghcr1/blobs/sha256:7621db36f0e51ae0bb9094d56ae5462fbf249969aff225555c1e5845fe7477c1
######################################################################## 100.0%
Error: openjdk@8: no bottle available!
You can try to install from source with:
brew install --build-from-source openjdk@8
Please note building from source is unsupported. You will encounter build
failures with some formulae. If you experience any issues please create pull
requests instead of asking for help on Homebrew's GitHub, Twitter or any other
official channels.


Alex@docmatters-mbp ~ % brew install --cask homebrew/cask-versions/adoptopenjdk8
==> Tapping homebrew/cask-versions
Cloning into '/opt/homebrew/Library/Taps/homebrew/homebrew-cask-versions'...
remote: Enumerating objects: 241929, done.
remote: Total 241929 (delta 0), reused 0 (delta 0), pack-reused 241929
Receiving objects: 100% (241929/241929), 61.76 MiB | 1.03 MiB/s, done.
Resolving deltas: 100% (167139/167139), done.
Tapped 205 casks (235 files, 68.5MB).
==> Caveats
Temurin is the official successor to this software:

brew install --cask temurin8

adoptopenjdk8 has been officially discontinued upstream.
It may stop working correctly (or at all) in recent versions of macOS.

==> Downloading https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u292-b10/OpenJDK8U-jdk_x64_mac_hotspot_8u292b10.pkg
==> Downloading from https://objects.githubusercontent.com/github-production-release-asset-2e65be/140418865/bbad4180-a2e0-11eb-8274-f16f6a90729c?X
######################################################################## 100.0%
==> Installing Cask adoptopenjdk8
==> Running installer for adoptopenjdk8; your password may be necessary.
Package installers may write to any location; options such as `--appdir` are ignored.
Password:
installer: Package name is AdoptOpenJDK
installer: Installing at base path /
installer: The install was successful.
🍺  adoptopenjdk8 was successfully installed!


vpn not available on the old machine

jdbc.driver = com.mysql.jdbc.Driver
jdbc.url = jdbc:mysql://10.2.2:14:8306/dm
jdbc.username = devdocmatter
jdbc.password = dev_docmatter_2015