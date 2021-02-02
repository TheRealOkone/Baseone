package com.example.Baseone.BACK;

import org.json.JSONObject;

import java.sql.*;

public class JDBCBase {

        static final String DATABASE_URL = "jdbc:mysql://localhost/PROSELYTE_JDBC_DB";
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

        static final String USER = "ВАШЕ_ИМЯ_ПОЛЬЗОВАТЕЛЯ";
        static final String PASSWORD = "ВАШ_ПАРОЛЬ";
        private  Connection connection = null;

        public void createconnection() throws ClassNotFoundException, SQLException {

            Statement statement = null;
            try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

            }
            catch(SQLException e) {
                e.printStackTrace();
                }
            }
        }
        public void select() {
            String tablename;
            Statement stm = null;
            try {
                stm = connection.createStatement();
                DatabaseMetaData md = connection.getMetaData();
                tablename = md.getTables(null,null,"%",null).getString(3);
                ResultSet rs = stm.executeQuery("select * from " + tablename);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }





}
