package com.aprj.models;

/**
 * Created by RickyWu on 2017/4/21.
 */
public class RecvCount {
    private Integer count;
    private String receiver;


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public RecvCount(Integer count, String sender) {
        this.count = count;
        this.receiver = sender;
    }
}
