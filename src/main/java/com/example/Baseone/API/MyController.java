package com.example.Baseone.API;


import com.example.Baseone.BACK.HibernateBase;
import com.example.Baseone.BACK.JDBCBase;
import com.example.Baseone.BACK.Strategy;
import com.example.Baseone.MODEL.RecordModel;
import com.example.Baseone.Reps.ModelRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org. springframework. stereotype. Controller;
import org.springframework.web.bind.annotation.*;

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

    private Strategy a = null;

    @Autowired
    ModelRepository rep;

    private Context d;

    @RequestMapping(value = "/records", method = RequestMethod. GET)
    public ResponseEntity<List<RecordModel>> retjson(){
        if(d == null){
            d = new Context(password, user,  db_url,  rep);
        }
        return d.retjson(a);
    }
    @RequestMapping(value = "/records", method = RequestMethod. POST)
    public void postjson(@RequestBody RecordModel w){
        if(d == null){
            d = new Context(password, user,  db_url,  rep);
        }
        a = d.postjson(a,w);
    }
    @RequestMapping(value = "/strategy", method = RequestMethod. POST)
    void strategyswitch(@RequestBody String str){
        if(d == null){
            d = new Context(password, user,  db_url,  rep);
        }
        a = d.strategyswitch(str);
    }

}

