package com.paulo.minipicpay.application;

public class TransferRequest {

    private final String senderCpf;
    private final String recipientCpf;
    private final Double amount;

    public TransferRequest(String senderCpf, String recipientCpf, Double amount) {
        this.senderCpf = senderCpf;
        this.recipientCpf = recipientCpf;
        this.amount = amount;
    }

    public Double amount() {
        return amount;
    }

    public String senderCpf() {
        return senderCpf;
    }

    public String recipientCpf() {
        return recipientCpf;
    }
}
