## Kafka installation
### VM instance(Ubuntu)
#### Prerequisite
- `sudo apt update && sudo apt install build-essential -y`

### Java
- `sudo apt-get install openjdk-8-jdk -y`

### Kafka download
- `wget https://downloads.apache.org/kafka/3.5.2/kafka_2.12-3.5.2.tgz && tar xzf kafka_2.12-3.5.2.tgz`


#### Environment variable
- `echo 'export KAFKA_HOME=/home/ubuntu/kafka_2.12-3.5.2' >> ~/.bashrc && source ~/.bashrc`
- `echo 'export KAFKA_HOME=/home/jihyun.jeong/kafka_2.12-3.5.2' >> ~/.bashrc && source ~/.bashrc`

- `cd $KAFKA_HOME`


#### Kafka server - Single node
- `vi $KAFKA_HOME/config/kraft/server.properties`

```
############################# Server Basics #############################

# The role of this server. Setting this puts us in KRaft mode
process.roles=broker,controller

# The node id associated with this instance's roles
node.id=1

# The connect string for the controller quorum
controller.quorum.voters=1@34.140.xx.xx:9093

# The default number of log partitions per topic. More partitions allow greater
# parallelism for consumption, but this will also result in more files across
# the brokers.
num.partitions=1

# Listener name, hostname and port the broker will advertise to clients.
# If not set, it uses the value for "listeners".
advertised.listeners=PLAINTEXT://34.140.xx.xx:9092

```

#### UUID - Cluster
- `export KAFKA_CLUSTER_ID="$($KAFKA_HOME/bin/kafka-storage.sh random-uuid)"`

#### Topic, partion
- `$KAFKA_HOME/bin/kafka-storage.sh format -t $KAFKA_CLUSTER_ID -c $KAFKA_HOME/config/kraft/server.properties`
  - Output: `Formatting /tmp/kraft-combined-logs`
- `cat /tmp/kraft-combined-logs/meta.properties`
  - ```
    cluster.id=c78-QRoJRyC46S42w0EPrw
    version=1
    node.id=1
    ```

### Memory sizing
- `echo 'export KAFKA_HEAP_OPTS="-Xmx8G -Xms8G"' >> ~/.bashrc`
- `vi ~/.bashrc`
  - `export KAFKA_HEAP_OPTS="-Xmx8G -Xms8G"`
- `source ~/.bashrc`


### Kafka start
- `$KAFKA_HOME/bin/kafka-server-start.sh -daemon $KAFKA_HOME/config/kraft/server.properties`
- `ps -ef | grep kafka`
  - ```
    jihyun.+   466  6937  0 12:06 pts/0    00:00:00 vi /home/jihyun.jeong/kafka_2.12-3.5.2/config/kraft/server.properties
    jihyun.+  1353   589  0 12:22 pts/1    00:00:00 grep --color=auto kafka
    jihyun.+ 27960     1  1 10:24 pts/0    00:01:33 java -Xmx8G -Xms8G -server -XX:+UseG1GC -XX:MaxGCPauseMillis=20 -XX:InitiatingHeapOccupancyPercent=35 -XX:+ExplicitGCInvokesConcurrent -XX:MaxInlineLevel=15 -Djava.awt.headless=true -Xloggc:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../logs/kafkaServer-gc.log -verbose:gc -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=10 -XX:GCLogFileSize=100M -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -Dkafka.logs.dir=/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../logs -Dlog4j.configuration=file:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../config/log4j.properties -cp /home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/activation-1.1.1.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/aopalliance-repackaged-2.6.1.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/argparse4j-0.7.0.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/audience-annotations-0.13.0.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/commons-cli-1.4.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/commons-lang3-3.8.1.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/connect-api-3.5.2.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/connect-basic-auth-extension-3.5.2.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/connect-json-3.5.2.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/connect-mirror-3.5.2.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/connect-mirror-client-3.5.2.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/connect-runtime-3.5.2.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/connect-transforms-3.5.2.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/hk2-api-2.6.1.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/hk2-locator-2.6.1.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/hk2-utils-2.6.1.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jackson-annotations-2.13.5.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jackson-core-2.13.5.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jackson-databind-2.13.5.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jackson-dataformat-csv-2.13.5.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jackson-datatype-jdk8-2.13.5.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jackson-jaxrs-base-2.13.5.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jackson-jaxrs-json-provider-2.13.5.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jackson-module-jaxb-annotations-2.13.5.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jackson-module-scala_2.12-2.13.5.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jakarta.activation-api-1.2.2.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jakarta.annotation-api-1.3.5.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jakarta.inject-2.6.1.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jakarta.validation-api-2.0.2.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jakarta.ws.rs-api-2.1.6.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jakarta.xml.bind-api-2.3.3.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/javassist-3.29.2-GA.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/javax.activation-api-1.2.0.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/javax.annotation-api-1.3.2.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/javax.servlet-api-3.1.0.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/javax.ws.rs-api-2.1.1.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jaxb-api-2.3.1.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jersey-client-2.39.1.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jersey-common-2.39.1.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jersey-container-servlet-2.39.1.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jersey-container-servlet-core-2.39.1.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jersey-hk2-2.39.1.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jersey-server-2.39.1.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jetty-client-9.4.52.v20230823.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jetty-continuation-9.4.52.v20230823.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jetty-http-9.4.52.v20230823.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jetty-io-9.4.52.v20230823.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jetty-security-9.4.52.v20230823.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jetty-server-9.4.52.v20230823.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jetty-servlet-9.4.52.v20230823.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jetty-servlets-9.4.52.v20230823.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jetty-util-9.4.52.v20230823.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jetty-util-ajax-9.4.52.v20230823.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jline-3.22.0.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jopt-simple-5.0.4.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/jose4j-0.9.3.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/kafka-clients-3.5.2.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/kafka-group-coordinator-3.5.2.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/kafka-log4j-appender-3.5.2.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/kafka-metadata-3.5.2.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/kafka-raft-3.5.2.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/kafka-server-common-3.5.2.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/kafka-shell-3.5.2.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/kafka-storage-3.5.2.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/kafka-storage-api-3.5.2.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/kafka-streams-3.5.2.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/kafka-streams-examples-3.5.2.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/kafka-streams-scala_2.12-3.5.2.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/kafka-streams-test-utils-3.5.2.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/kafka-tools-3.5.2.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/kafka-tools-api-3.5.2.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/kafka_2.12-3.5.2.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/lz4-java-1.8.0.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/maven-artifact-3.8.8.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/metrics-core-2.2.0.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/metrics-core-4.1.12.1.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/netty-buffer-4.1.94.Final.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/netty-codec-4.1.94.Final.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/netty-common-4.1.94.Final.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/netty-handler-4.1.94.Final.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/netty-resolver-4.1.94.Final.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/netty-transport-4.1.94.Final.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/netty-transport-classes-epoll-4.1.94.Final.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/netty-transport-native-epoll-4.1.94.Final.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/netty-transport-native-unix-common-4.1.94.Final.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/osgi-resource-locator-1.0.3.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/paranamer-2.8.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/plexus-utils-3.3.1.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/reflections-0.9.12.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/reload4j-1.2.25.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/rocksdbjni-7.9.2.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/scala-collection-compat_2.12-2.10.0.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/scala-java8-compat_2.12-1.0.2.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/scala-library-2.12.15.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/scala-logging_2.12-3.9.4.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/scala-reflect-2.12.15.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/slf4j-api-1.7.36.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/slf4j-reload4j-1.7.36.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/snappy-java-1.1.10.5.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/swagger-annotations-2.2.8.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/trogdor-3.5.2.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/zookeeper-3.6.4.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/zookeeper-jute-3.6.4.jar:/home/jihyun.jeong/kafka_2.12-3.5.2/bin/../libs/zstd-jni-1.5.5-1.jar kafka.Kafka /home/jihyun.jeong/kafka_2.12-3.5.2/config/kraft/server.properties
    ```