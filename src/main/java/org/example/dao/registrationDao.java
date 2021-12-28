package org.example.dao;

import org.example.domain.registration;
import org.example.utils.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class registrationDao {
    public void regist(String dname,String pname,String massage){
        jdbc jdbc =new jdbc();
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement p=null;
        conn = jdbc.getConn();
        System.out.println("sql连接池已打开");
        try{
            p=conn.prepareStatement("insert into registration(dname,pname,massage) values (?,?,?)");
            p.setString(1,dname);
            p.setString(2,pname);
            p.setString(3,massage);
            p.execute();
            System.out.println("success");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.closeAll(null,p,null);
        }
    }
    public List<registration> call(String dname){
        jdbc jdbc =new jdbc();
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement p=null;
        conn = jdbc.getConn();
        List<registration> registrations =new ArrayList<>();
        System.out.println("sql连接池已打开");
        try{
            p=conn.prepareStatement("select * from registration where dname=? and cure=0");
            p.setString(1,dname);
            rs=p.executeQuery();
            while (rs.next()){
                registration registration=new registration();
                registration.setDname(rs.getString("dname"));
                registration.setPname(rs.getString("pname"));
                registration.setMassage(rs.getString("massage"));
                registration.setTime(rs.getString("time"));
                registrations.add(registration);
            }

            System.out.println("success");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.closeAll(null,p,null);
        }return registrations;
    }
    public List<registration> call_all(){
        jdbc jdbc =new jdbc();
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement p=null;
        conn = jdbc.getConn();
        List<registration> registrations =new ArrayList<>();
        System.out.println("sql连接池已打开");
        try{
            p=conn.prepareStatement("select * from registration");
            rs=p.executeQuery();
            while (rs.next()){
                registration registration=new registration();
                registration.setDname(rs.getString("dname"));
                registration.setPname(rs.getString("pname"));
                registration.setMassage(rs.getString("massage"));
                registration.setTime(rs.getString("time"));
                registrations.add(registration);
            }
            System.out.println("success");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.closeAll(null,p,null);
        }return registrations;
    }
    public void cure(int id) {
        jdbc jdbc = new jdbc();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement p = null;
        conn = jdbc.getConn();
        try {
            p = conn.prepareStatement("update registration set cure=1 where id=?");
            p.setInt(1,id);
            p.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
