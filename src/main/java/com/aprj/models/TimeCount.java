package com.aprj.models;

import java.util.List;

/**
 * Created by RickyWu on 2017/4/21.
 */
public class TimeCount {
    private Integer count;
    private String time;

    public List<String> getIds() {
        return Ids;
    }

    public void setIds(List<String> ids) {
        Ids = ids;
    }

    private List<String> Ids;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
