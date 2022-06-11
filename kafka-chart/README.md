# Install bitnamy kafka helm chart on k8s/openshift for testing kafka applications
1. Connect to a cluster, and run helm install of the chart with the following override values.yaml:
```shell
helm install bitnami/kafka -f values.yaml
```
2. connect to kafka broker shell using oc exec/oc rsh:
```
oc rsh kafka-0 bash
```
3. run a producer to generate messages:
```shell
kafka-console-producer.sh \         
  --broker-list kafka-0.kafka-headless.kafka-test.svc.cluster.local:9092 \
  --topic topic-name
```
4. Insert some messages into topic
```json
{"paymentIncluded": true, "amount": 1500, "loan": false, "inAdvanceFee": "no"}
```
5. If you want to consume the message, you can run from the kafka container a consumer client:
```shell
kafka-console-consumer.sh \            
   --bootstrap-server kafka.kafka-test.svc.cluster.local:9092 \
   --topic test \
   --from-beginning
```
6. Now in order to connect the application to cluster, all you have to do is to port-forward pod/service port 9092 of kafka broker to localhost:9092
```shell
oc port-forward svc/kafka 9092
```

Now the application is ready to work with kafka.

