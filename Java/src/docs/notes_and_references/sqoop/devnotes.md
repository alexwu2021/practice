## while installing sqoop, it actually installs the following dependency:
gmp, coreutils, lzo, openjdk@11, hbase, ca-certificates, openssl@1.1 and zookeepe

/usr/local/Cellar will contain the following pieces:
    ca-certificates	
    freetype	
    hadoop		
    hive		
    lzo		
    openjdk@11	
    openssl@1.1	
    zookeeper
    coreutils	
    gmp		
    hbase		
    libpng		
    openjdk		
    openjdk@8	
    sqoop

## config folder of sqoop
/usr/local/Cellar/sqoop/1.4.7/libexec/con




## hive internal error
hive> show tables;
OK
ctxentity
ctxmessage
post_comm
Time taken: 0.175 seconds, Fetched: 3 row(s)
hive> select * from ctxentity;
FAILED: SemanticException Unable to determine if hdfs://localhost:9000/user/hive/warehouse/kpi_hive.db/ctxentity is encrypted: org.apache.hadoop.hive.ql.metadata.HiveException: java.net.ConnectException: Call From mp-2020-5.lan/192.168.86.107 to localhost:9000 failed on connection exception: java.net.ConnectException: Connection refused; For more details see:  http://wiki.apache.org/hadoop/ConnectionRefused
hive>




sqoop eval --connect jdbc:mysql://localhost:10000/default -- query "select  10 " 



## i probably should use hadoop 2.6.0 such that I can use sqoop 1.4.7


