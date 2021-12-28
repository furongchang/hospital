package org.example.dao;

import org.example.utils.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class evaluateDao {
    public void evaluate(int star,String id){
        jdbc jdbc =new jdbc();
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement p=null;
        conn = jdbc.getConn();
        System.out.println("sql连接池已打开");
        try{
            p=conn.prepareStatement("update prescription set star=? where id=?");
            p.setInt(1,star);
            p.setString(2,id);
            System.out.println("star:"+star);
            System.out.println("id:"+id);
            p.executeUpdate();
            System.out.println("success");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.closeAll(null,p,null);
        }
    }
}
