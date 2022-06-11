package com.example.kafkasample.consumer;

import com.example.kafkasample.model.PaymentEventRecord;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PaymentsListener {
    private final Environment environment;
    private ObjectMapper om = new ObjectMapper();
    @KafkaListener(groupId = "payment_consumers",topics = "payments")
    public void listen(String in) {
        String formattedJson=in;
        PaymentEventRecord per;
        try {
            per = om.readValue(in, PaymentEventRecord.class);
            formattedJson=om.writerWithDefaultPrettyPrinter().writeValueAsString(per);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        log.info("got payment with the following details : " + formattedJson);
        System.out.println(formattedJson);

    }
}
