package org.example.utils;

import java.sql.*;
import java.util.List;

public class jdbc {
    public static final String URL="jdbc:mysql://localhost:3306/hospital?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
    public static final String USER="example";
    public static final String PASSWORD="1052455899";

    public  Connection getConn(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return conn;
    }

    public  void closeAll(ResultSet rs, PreparedStatement stmt, Connection conn){
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }catch (SQLException e){
            System.out.println("");
            e.printStackTrace();
        }
    }
}
