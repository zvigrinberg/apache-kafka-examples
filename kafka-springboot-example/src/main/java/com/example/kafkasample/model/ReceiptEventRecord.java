package com.example.kafkasample.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class ReceiptEventRecord {
    private String paymentId;
    private UUID approvalNumber;
    private String payingCustomer;
    private LocalDate paymentDate;
    private Integer amountPaid;
    private boolean loanIncluded;
    private String inAdvanceFee;
    private String item;
    private String processingInstance;

    public ReceiptEventRecord(String paymentId, String payingCustomer, Integer amountPaid, boolean loanIncluded, String inAdvanceFee,String item,String processingInstance) {
        this.paymentId = paymentId;
        this.payingCustomer = payingCustomer;
        this.amountPaid = amountPaid;
        this.loanIncluded = loanIncluded;
        this.inAdvanceFee = inAdvanceFee;
        this.paymentDate = LocalDate.now();
        this.approvalNumber = UUID.randomUUID();
        this.item = item;
        this.processingInstance = processingInstance;
    }
}
