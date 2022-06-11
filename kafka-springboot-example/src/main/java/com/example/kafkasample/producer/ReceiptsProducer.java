package com.example.kafkasample.producer;

import com.example.kafkasample.model.ReceiptEventRecord;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
@RequiredArgsConstructor
@Slf4j
public class ReceiptsProducer {
    private final KafkaTemplate<Integer, ReceiptEventRecord> kafkaTemplate;

    public void sendReceiptToTopic(ReceiptEventRecord receipt) {
        ListenableFuture<SendResult<Integer, ReceiptEventRecord>> receipts = kafkaTemplate.send("receipts", receipt);
        receipts.addCallback(new ListenableFutureCallback<SendResult<Integer, ReceiptEventRecord>>() {
            @Override
            public void onFailure(Throwable ex) {
                 log.error("unable to send message: " + receipt.toString() + "because of the following error: " + ex.getMessage() );
            }

            @Override
            public void onSuccess(SendResult<Integer, ReceiptEventRecord> result) {
                log.info("successfully sent message : " + receipt.toString() + " to kafka topic receipts " + ", metadata record=  " +  result.getRecordMetadata() + " , producer record:  " + result.getProducerRecord() );
            }
        });
    }
}
