package com.aprj.models;

/**
 * Created by southdom on 2017/4/22.
 */
public class Link {
    private String source;
    private String target;
    private String value;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Link(String source, String target, String value) {
        this.source = source;
        this.target = target;
        this.value = value;
    }
}
