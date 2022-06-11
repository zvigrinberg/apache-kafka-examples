package com.example.kafkasample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class PaymentEventRecord {
    private String customerId;
    private String paymentId;
    private String item;
    private Integer amount;
    private boolean loan;
    private String inAdvanceFee;

}
