
There is permission issues with the temporary folder.

hdfs dfs -chmod -R 777 /tmp/hive

Run this command and it fixed it.


hive> INSERT INTO TABLE Names_part PARTITION(state='PA')
> SELECT EmployeeID, FirstName, Title, Laptop FROM Names_text WHERE state='PA';
...
OK