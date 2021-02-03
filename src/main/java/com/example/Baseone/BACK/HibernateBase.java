package com.example.Baseone.BACK;

import com.example.Baseone.MODEL.RecordModel;
import com.example.Baseone.Reps.ModelRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class HibernateBase implements Strategy{

    String db_url;
    String user;
    String password;
    ModelRepository rep;
    public HibernateBase(String db_url,String user,String password,ModelRepository rep){
        this.user = user;
        this.password = password;
        this.db_url = db_url;
        this.rep = rep;
    }

    @Override
    public void createconnection() {

    }

    @Override
    public ResponseEntity<List<RecordModel>> select() {
        return new ResponseEntity<List<RecordModel>>(rep.findAll(), HttpStatus.OK);
    }

    @Override
    public void insert(String name, String data) {
        rep.save(new RecordModel(7865545,name,data));
    }

    @Override
    public void close() {

    }
}
