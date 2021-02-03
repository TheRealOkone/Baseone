package com.example.Baseone.API;


import com.example.Baseone.BACK.HibernateBase;
import com.example.Baseone.BACK.JDBCBase;
import com.example.Baseone.BACK.Strategy;
import com.example.Baseone.MODEL.RecordModel;
import com.example.Baseone.Reps.ModelRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class Context {
    private String password;

    private String user;

    private String db_url;

    ModelRepository rep;

    public Context(String password, String user, String db_url, ModelRepository rep) {
        this.password = password;
        this.user = user;
        this.db_url = db_url;
        this.rep = rep;
    }

    public ResponseEntity<List<RecordModel>> retjson(Strategy a){
        if (a == null) {
            a = new JDBCBase(db_url, user, password);
        }
        ResponseEntity<List<RecordModel>> b;
        if(a.getClass().getSimpleName().equals("JDBCBase")) {
            a.createconnection();
            b = a.select();
            //a.insert("cringe","bruh");
            a.close();
        }
        else{
            b = a.select();
        }
        return b;
    }

    public Strategy postjson(Strategy a, RecordModel w){
        if(a == null){
            a = new JDBCBase(db_url,user,password);
        }
        if(a.getClass().getSimpleName().equals("JDBCBase")) {
            a.createconnection();
            a.insert(w.getName(), w.getData());
            a.close();
        }
        else{
            a.insert(w.getName(), w.getData());
        }
        return a;
    }


    Strategy strategyswitch( String str){
        Strategy a = null;
        if(str.toLowerCase().equals("jdbc")){
            a = new JDBCBase(db_url,user,password);
        }
        if(str.toLowerCase().equals("hibernate")){
            a = new HibernateBase(db_url,user,password,rep);
        }
        return a;
    }

}
