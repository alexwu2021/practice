CREATE SCHEMA IF NOT EXISTS bdp;

use bdp;



CREATE EXTERNAL TABLE IF NOT EXISTS bdp.a
(id INT,
TYPE STRING)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
;


CREATE EXTERNAL TABLE IF NOT EXISTS bdp.b
(id INT,
TYPE STRING)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
;



LOAD DATA LOCAL INPATH  '/Users/Alex/repo/poc-mp/poc-mp/src/main/resources/hive/test/bdp_a' INTO TABLE a ;

LOAD DATA LOCAL INPATH  '/Users/Alex/repo/poc-mp/poc-mp/src/main/resources/hive/test/bdp_b' INTO TABLE b ;