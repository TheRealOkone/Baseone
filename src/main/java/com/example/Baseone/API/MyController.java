package com.example.Baseone.API;


import com.example.Baseone.BACK.JDBCBase;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org. springframework. stereotype. Controller;
import org. springframework. web. bind. annotation. RequestMapping;
import org. springframework. web. bind. annotation. RequestMethod;


@Controller
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
    public String retjson(){
        JDBCBase a = new JDBCBase(db_url,user,password);
        a.select();
        a.close();
        return "bruh";
    }
    @RequestMapping(value = "/records", method = RequestMethod. POST)
    public void postjson(JSONObject bruh){

    }
    @RequestMapping(value = "/strategy", method = RequestMethod. POST)
    void strategyswitch(){

    }

}

