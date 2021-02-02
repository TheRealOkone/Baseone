package com.example.Baseone.MODEL;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecordModel {
    @JsonProperty("id")
    int id;
    @JsonProperty("name")
    String name;
    @JsonProperty("data")
    String data;

    public RecordModel(int id, String name, String data) {
        this.id = id;
        this.name = name;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }
}
