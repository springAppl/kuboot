#!/bin/bash
echo '####################################################'
echo  $MYSQL_DB_HOST
echo '####################################################'
redis-server --daemonize yes
java -jar kuboot-0.0.1-SNAPSHOT.jar