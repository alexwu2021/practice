drop database kpi_hive cascade;
create database kpi_hive;
use kpi_hive;





create external table ctxentity (ctxtype INT, ctxid INT, name STRING ) row format delimited FIELDS TERMINATED BY ',' COLLECTION ITEMS TERMINATED BY '\n' ;
LOAD DATA LOCAL INPATH  '/Users/Alex/repo/poc-mp/poc-mp/src/main/resources/mapred/input/ctxentity.mpi' INTO TABLE ctxentity ;

create external table ctxmessage (msid INT, level INT, THREAD_MSID INT, state INT, CREATED_DATE STRING) row format delimited FIELDS TERMINATED BY ',' COLLECTION ITEMS TERMINATED BY '\n' ;
LOAD DATA LOCAL INPATH  '/Users/Alex/repo/poc-mp/poc-mp/src/main/resources/mapred/input/ctxmessage.mpi' INTO TABLE ctxmessage ;

create external table post_comm (id INT, msid INT, ctxtype INT, ctxid INT, type INT, created_date STRING, created_by INT, last_modified_date STRING, last_updated_by INT, access_ctxtype INT, access_ctxid INT, mode INT) row format delimited FIELDS TERMINATED BY ',' COLLECTION ITEMS TERMINATED BY '\n' ;
LOAD DATA LOCAL INPATH  '/Users/Alex/repo/poc-mp/poc-mp/src/main/resources/mapred/input/post_comm.mpi' INTO TABLE post_comm ;

