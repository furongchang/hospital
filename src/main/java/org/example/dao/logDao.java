package org.example.dao;

import org.example.domain.log;
import org.example.utils.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class logDao {
    public void log(String user,String time,String ip,String visit,String status){
        jdbc jdbc=new jdbc();
        Connection conn=null;
        conn=jdbc.getConn();
        PreparedStatement p=null;
        try {
            p=conn.prepareStatement("insert into log (user,time,ip,visit,status)values (?,?,?,?,?)");
            p.setString(1,user);
            p.setString(2,time);
            p.setString(3,ip);
            p.setString(4,visit);
            p.setString(5,status);
            p.executeUpdate();
            System.out.println("log");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.closeAll(null,p,null);
        }
    }
    public List<log> log_show(){
        jdbc jdbc =new jdbc();
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement p=null;
        List<log> logs=new ArrayList<>();
        conn = jdbc.getConn();
        try{
            p=conn.prepareStatement("select * from log");
            rs=p.executeQuery();
            while (rs.next()) {
                log log=new log();
                log.setIp(rs.getString("ip"));
                log.setStatus(rs.getString("status"));
                log.setTime(rs.getString("time"));
                log.setUser(rs.getString("user"));
                log.setVisit(rs.getString("visit"));
                logs.add(log);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.closeAll(null,p,null);
        }return logs;
    }
}
