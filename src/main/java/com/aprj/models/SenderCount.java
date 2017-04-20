package com.aprj.models;


/**
 * Created by southdom on 2017/4/20.
 */
public class SenderCount {
    private Integer count;
    private String sender;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public SenderCount(Integer count, String sender) {
        this.count = count;
        this.sender = sender;
    }
}
