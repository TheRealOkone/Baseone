package com.example.Baseone.API;

import org.json.JSONObject;
import org. springframework. stereotype. Controller;
import org. springframework. web. bind. annotation. RequestMapping;
import org. springframework. web. bind. annotation. RequestMethod;


@Controller
public class MyController {
    @RequestMapping(value = "/records", method = RequestMethod. GET)
    public JSONObject retjson(){

        return null;
    }
    @RequestMapping(value = "/records", method = RequestMethod. POST)
    public void postjson(JSONObject bruh){

    }
    @RequestMapping(value = "/strategy", method = RequestMethod. POST)
    void strategyswitch(){

    }

}

