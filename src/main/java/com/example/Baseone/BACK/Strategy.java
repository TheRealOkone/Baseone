package com.example.Baseone.BACK;

import com.example.Baseone.MODEL.RecordModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Strategy {
    public void createconnection();
    public ResponseEntity<List<RecordModel>> select();
    public void insert(String name,String data);
    public void close();
}
