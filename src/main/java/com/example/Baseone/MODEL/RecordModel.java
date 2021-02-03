package com.example.Baseone.MODEL;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Generated;

import javax.persistence.*;

@Entity
@Table(name = "bruh")
public class RecordModel {
    @Id @GeneratedValue
    @Column(name = "id")
    @JsonProperty("id")
    private int id;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @Column(name = "data")
    @JsonProperty("data")
    private String data;

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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setData(String data) {
        this.data = data;
    }
}
