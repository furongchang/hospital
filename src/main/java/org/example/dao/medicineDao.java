package org.example.dao;

import org.example.domain.doctor;
import org.example.domain.medicine;
import org.example.utils.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class medicineDao {
    public void addm(String id, String name, String introduce) {
        jdbc jdbc = new jdbc();
        Connection conn = null;
        conn = jdbc.getConn();
        System.out.println("sql连接池已打开");
        try {
            PreparedStatement p = conn.prepareStatement("insert into medicine (id,name,introduce) values (?,?,?)");
            p.setString(1, id);
            p.setString(2, name);
            p.setString(3, introduce);
            p.execute();
            System.out.println("addm success");
            jdbc.closeAll(null, p, conn);
            System.out.println("sql连接池已关闭");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<medicine> querym(String name) {
        jdbc jdbc = new jdbc();
        Connection conn = null;
        PreparedStatement p=null;
        ResultSet rs=null;
        conn = jdbc.getConn();
        List<medicine> medicineList = new ArrayList<>();
        System.out.println("sql连接池已打开");
        try {
            p = conn.prepareStatement("select id,name,introduce  from medicine where name=?");
            p.setString(1, name);
            rs = p.executeQuery();
            while (rs.next()) {
                medicine medicine = new medicine();
                medicine.setName(rs.getString("name"));
                medicine.setId(rs.getString("id"));
                medicine.setIntroduce((rs.getString("introduce")));
                medicineList.add(medicine);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.closeAll(rs,p,null);
        }
        return medicineList;
    }
    public List<medicine> querym_all() {
        jdbc jdbc = new jdbc();
        Connection conn = null;
        PreparedStatement p=null;
        ResultSet rs=null;
        conn = jdbc.getConn();
        List<medicine> medicineList = new ArrayList<>();
        System.out.println("sql连接池已打开");
        try {
            p = conn.prepareStatement("select id,name,introduce  from medicine ");
            rs = p.executeQuery();
            while (rs.next()) {
                medicine medicine = new medicine();
                medicine.setName(rs.getString("name"));
                medicine.setId(rs.getString("id"));
                medicine.setIntroduce((rs.getString("introduce")));
                medicineList.add(medicine);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.closeAll(rs,p,null);
        }
        return medicineList;
    }
    public void delm(String id){
        jdbc jdbc = new jdbc();
        Connection conn = null;
        PreparedStatement p=null;
        ResultSet rs=null;
        conn = jdbc.getConn();
        System.out.println("sql连接池已打开");
        try {
            p=conn.prepareStatement("delete from medicine where id=?");
            p.setString(1,id);
            p.execute();
            System.out.println("delMedicine success");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.closeAll(null,p,null);
        }
    }
}
