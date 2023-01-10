5978 as the root password for the local mysql instance

/usr/local/Cellar/hive/3.1.2_3/libexec/scripts/metastore/upgrade/mysql/hive-schema-3.1.0.mysql.sql
/opt/homebrew/Cellar/hive/3.1.2_3/libexec/libexec/scripts/metastore/upgrade/mysql/hive-schema-3.1.0.mysql.sql

after turning on remote login for Alex, I came acrosss the following





Alex@docmatters-mbp ~ % cat $HOME/.ssh/id_rsa.pub >> $HOME/.ssh/authorized_keys
Alex@docmatters-mbp ~ % ssh localhost                                          
The authenticity of host 'localhost (::1)' can't be established.
ECDSA key fingerprint is SHA256:RggX8R7pnuOLB2IMTlR3UT4J7fohaves+WQCted5EPk.
Are you sure you want to continue connecting (yes/no/[fingerprint])? yes
Warning: Permanently added 'localhost' (ECDSA) to the list of known hosts.
Last login: Sat Dec 18 23:16:13 2021
Alex@docmatters-mbp ~ % ssh localhost      
Last login: Sat Dec 18 23:17:38 2021 from ::1


## what to config for this file: /opt/homebrew/Cellar/hadoop/3.3.1/libexec/etc/hadoop/hadoop-env.sh