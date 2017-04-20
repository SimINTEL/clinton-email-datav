package com.aprj.models;

/**
 * Created by southdom on 2017/4/20.
 */
public class PodestasNode {
    private String value;
    private String id;
    private String from_count;
    private String to_count;
    private String site;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFrom_count() {
        return from_count;
    }

    public void setFrom_count(String from_count) {
        this.from_count = from_count;
    }

    public String getTo_count() {
        return to_count;
    }

    public void setTo_count(String to_count) {
        this.to_count = to_count;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public PodestasNode(String value, String id, String from_count, String to_count, String site) {
        this.value = value;
        this.id = id;
        this.from_count = from_count;
        this.to_count = to_count;
        this.site = site;
    }
}
