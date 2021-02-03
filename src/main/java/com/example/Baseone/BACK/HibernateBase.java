package com.example.Baseone.BACK;

import com.example.Baseone.MODEL.RecordModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class HibernateBase implements Strategy{

    String db_url;
    String user;
    String password;
    public HibernateBase(String db_url,String user,String password){
        this.user = user;
        this.password = password;
        this.db_url = db_url;
    }

    @Override
    public void createconnection() {

    }

    @Override
    public ResponseEntity<List<RecordModel>> select() {
        return null;
    }

    @Override
    public void insert(String name, String data) {

    }

    @Override
    public void close() {

    }
}
