echo "copying the resulting war from the target/prod folder to the remote box"

ls -la /Users/Alex/repo/poc-mp/poc-mp/target/poc-mp.war
scp /Users/Alex/repo/poc-mp/poc-mp/prod/target/poc-mp.war prodadmin@10.2.1.12:poc-mp.war


