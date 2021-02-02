package com.example.Baseone.BACK;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import java.sql.*;
public class JDBCBase {


        String db_url;

        static final String JDBC_DRIVER = "org.postgresql.Driver";

        String user;

        String password;



    private  Connection connection = null;
        public JDBCBase(String db_url,String user,String password){
            this.user = user;
            this.password = password;
            this.db_url = db_url;
            try {
                this.createconnection();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        public void createconnection() throws ClassNotFoundException, SQLException {

            Statement statement = null;
            try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(db_url, user, password);
            }
            catch(SQLException e) {
                e.printStackTrace();
                }
            }

        public void select() {
            String tablename;
            Statement stm = null;
            try {
                stm = connection.createStatement();
                ResultSet rs = stm.executeQuery("select * from bruh");
                System.out.println(rs);
                while(rs.next()){
                    System.out.println(rs.getInt(1));
                    System.out.println(rs.getString(2));
                    System.out.println(rs.getString(3));
                }
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
