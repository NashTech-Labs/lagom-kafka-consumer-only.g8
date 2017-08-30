A [Giter8][g8] template for only consuming data from kafka topic using external kafka in Lagom framework.

About Template
----------------------
# Lagom Framework + Kafka Integration

 This is an template which only consumes data from a topic using external kafka in Lagom framework.

 ---

 Clone Project

 ```bash
 git clone git@github.com:knoldus/lagom-kafka-consumer-only.g8.git
 cd lagom-kafka-consumer-only/src/main/g8
 mvn lagom:runAll

 ```
 ---
## Application runs on port `http://localhost:9000`

### Consume message fro kafka topic

The application subscribes to the topic greeting and dump out messages to standard output.

----------------
Written in 2017​ by [Knoldus Software LLP](http://knoldus.com)
[other author/contributor lines as appropriate]
To the extent possible under law, the author(s) have dedicated all copyright and
related
and neighboring rights to this template to the public domain worldwide.
This template is distributed without any warranty. See
<http://creativecommons.org/publicdomain/zero/1.0/>.
[g8]: http://www.foundweekends.org/giter8/
