package com.example.Baseone.API;


import com.example.Baseone.BACK.JDBCBase;
import com.example.Baseone.MODEL.RecordModel;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org. springframework. stereotype. Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org. springframework. web. bind. annotation. RequestMapping;
import org. springframework. web. bind. annotation. RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MyController {

    @Autowired
    @Value("${user.password}")
    private String password;
    @Autowired
    @Value("${user.user}")
    private String user;
    @Autowired
    @Value("${user.db_url}")
    private String db_url;

    @RequestMapping(value = "/records", method = RequestMethod. GET)
    public ResponseEntity<List<RecordModel>> retjson(){
        JDBCBase a = new JDBCBase(db_url,user,password);
        ResponseEntity<List<RecordModel>> b = a.select();
        //a.insert("cringe","bruh");
        a.close();
        return b;
    }
    @RequestMapping(value = "/records", method = RequestMethod. POST)
    public void postjson(@RequestBody RecordModel w){

        JDBCBase a = new JDBCBase(db_url,user,password);
        a.insert(w.getName(),w.getData());
        a.close();
    }
    @RequestMapping(value = "/strategy", method = RequestMethod. POST)
    void strategyswitch(){

    }

}

