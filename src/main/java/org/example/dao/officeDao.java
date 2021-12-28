package org.example.dao;

import org.example.domain.medicine;
import org.example.domain.office;
import org.example.utils.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class officeDao {
    public void add_office(String id, String name, String introduce) {
        jdbc jdbc = new jdbc();
        Connection conn = null;
        conn = jdbc.getConn();
        System.out.println("sql连接池已打开");
        try {
            PreparedStatement p = conn.prepareStatement("insert into office (id,name,introduce) values (?,?,?)");
            p.setString(1, id);
            p.setString(2, name);
            p.setString(3, introduce);
            p.execute();
            System.out.println("add_office success");
            jdbc.closeAll(null, p, null);
            System.out.println("sql连接池已关闭");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void del_office(String id){
        jdbc jdbc = new jdbc();
        Connection conn = null;
        PreparedStatement p=null;
        ResultSet rs=null;
        conn = jdbc.getConn();
        System.out.println("sql连接池已打开");
        try {
            p=conn.prepareStatement("delete from office where id=?");
            p.setString(1,id);
            p.execute();
            System.out.println("delOffice success");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.closeAll(null,p,null);
        }
    }
    public  List<office> query_office(String name) {
        jdbc jdbc = new jdbc();
        Connection conn = null;
        PreparedStatement p=null;
        ResultSet rs=null;
        conn = jdbc.getConn();
        List<office> offices = new ArrayList<>();
        System.out.println("sql连接池已打开");
        try {
            p = conn.prepareStatement("select id,name,introduce  from office where name=?");
            p.setString(1, name);
            rs = p.executeQuery();
            while (rs.next()) {
                office office=new office();
                office.setName(rs.getString("name"));
                office.setId(rs.getString("id"));
                office.setIntroduce((rs.getString("introduce")));
                offices.add(office);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.closeAll(rs,p,null);
        }
        return offices;
    }
    public List<office> queryall_office() {
        jdbc jdbc = new jdbc();
        Connection conn = null;
        PreparedStatement p=null;
        ResultSet rs=null;
        conn = jdbc.getConn();
        List<office> offices = new ArrayList<>();
        System.out.println("sql连接池已打开");
        try {
            p = conn.prepareStatement("select id,name,introduce  from office ");
            rs = p.executeQuery();
            while (rs.next()) {
                office office=new office();
                office.setName(rs.getString("name"));
                office.setId(rs.getString("id"));
                office.setIntroduce((rs.getString("introduce")));
                offices.add(office);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.closeAll(rs,p,null);
        }
        return offices;
    }
}
