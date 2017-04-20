package com.aprj.models;

/**
 * Created by RickyWu on 2017/4/20.
 */
public class UrlCountModel {
    private String url;
    private Integer count;

    public UrlCountModel(String u,Integer c){
        url=u;
        count=c;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
