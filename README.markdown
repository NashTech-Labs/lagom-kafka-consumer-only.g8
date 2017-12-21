A [Giter8][g8] template for showcasing only consuming data from kafka topic using external kafka in Lagom framework. 

## Lagom Framework + Kafka Integration

 This is a template which only consumes data from a topic using external kafka in Lagom framework. In this application, we have not created any producer. Producer will be external, this application will only consume the data.

### Steps to install Zookeeper and Apache Kafka:

Step 1: Download Kafka

Download Kafka from [here](http://www-eu.apache.org/dist/kafka/1.0.0/kafka_2.11-1.0.0.tgz)

Step 2: Extract downloaded file

```bash
tar -xzvf kafka_2.11-1.0.0.tgz
cd kafka_2.11-1.0.0
```
### Steps to start Zookeeper and Kafka server :

Start Zookeeper:

```bash
bin/zookeeper-server-start.sh config/zookeeper.properties
```

Start Kafka server:

```bash
bin/kafka-server-start.sh config/server.properties
```

### Clone Project

```bash
sbt new knoldus/lagom-kafka-consumer-only.g8
cd lagom-kafka-consumer-only
sbt clean compile
```

### Run Application
sbt runAll

### Steps to produce a message on kafka topic :

Step 1: Create topic

bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic greetings

Step 2 : Send message

bin/kafka-console-producer.sh --broker-list localhost:9092 --topic greetings
{"message" : "HI"}

## Application runs on port `http://localhost:9000`

### Consume message from kafka topic

The application subscribes to the topic greeting and dump out messages to standard output. To verify, we need to check the console after producing message on kafka.

----------------
Written in 2017​ by Rishi Khandelwal

To the extent possible under law, the author(s) have dedicated all copyright and related
and neighboring rights to this template to the public domain worldwide.
This template is distributed without any warranty. See <http://creativecommons.org/publicdomain/zero/1.0/>.

[g8]: http://www.foundweekends.org/giter8/
