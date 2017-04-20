package com.aprj.models;

import java.math.BigDecimal;

/**
 * Created by southdom on 2017/4/20.
 */
public class MoneyCountModel {

    private BigDecimal amount;
    private String sender;
    private String receiver;

    public MoneyCountModel(BigDecimal amount, String sender, String receiver) {
        this.amount = amount;
        this.sender = sender;
        this.receiver = receiver;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
