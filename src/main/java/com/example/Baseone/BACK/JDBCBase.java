package com.example.Baseone.BACK;


import com.example.Baseone.MODEL.RecordModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.*;
import java.sql.*;
public class JDBCBase implements Strategy{


        String db_url;

        static final String JDBC_DRIVER = "org.postgresql.Driver";

        String user;

        String password;



    private  Connection connection = null;
        public JDBCBase(String db_url,String user,String password){
            this.user = user;
            this.password = password;
            this.db_url = db_url;

        }
        public void createconnection(){

            Statement statement = null;
            try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(db_url, user, password);
            }
            catch(Exception e) {
                e.printStackTrace();
                }
            }

        public ResponseEntity<List<RecordModel>> select() {
            Statement stm = null;
            List <RecordModel> lst = new ArrayList<>();
            try {
                stm = connection.createStatement();
                ResultSet rs = stm.executeQuery("select * from bruh");
                while(rs.next()){
                    lst.add(new RecordModel(rs.getInt(1),rs.getString(2),rs.getString(3)));
                }
                return new ResponseEntity<List<RecordModel>>(lst, HttpStatus.OK);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return new ResponseEntity<List<RecordModel>>(lst, HttpStatus.OK);
        }
        public void insert(String name,String data){
            Statement stm = null;
            try {
                stm = connection.createStatement();
                stm.executeUpdate("insert into public.bruh (name,data) values ('"+ name +"','"+ data +"')");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        public void close() {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }




}
