# apache-kafka-examples
Apache kafka examples with spring boot and quarkus

- Create Microservice with 2 replicas that will consume from a topic events, 
  then will generate records from this data to be inserted to db or produced into another kafka topic.
- The consuming will be using a consumer group, so each replica will consume from its partition of the same topic
  , which will provide scalability and will increase throughput of events consumption, and real parallelism in case kafka cluster is with more than 1 broker node.
