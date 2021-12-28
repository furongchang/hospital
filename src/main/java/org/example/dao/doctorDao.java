package org.example.dao;

import org.example.domain.doctor;
import org.example.utils.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class doctorDao {
    public List<doctor> doctor_show(String name) {
        jdbc jdbc = new jdbc();
        Connection conn = null;
        conn = jdbc.getConn();
        List<doctor> doctorlist = new ArrayList<>();
        try {
            PreparedStatement p = conn.prepareStatement("select username,password,name,sex,phone,office from doctor_log where name=?");
            p.setString(1, name);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                doctor doctor = new doctor();
                doctor.setUsername(rs.getString("username"));
                doctor.setPassword(rs.getString("password"));
                doctor.setName(rs.getString("name"));
                doctor.setSex(rs.getString("sex"));
                doctor.setPhone(rs.getString("phone"));
                doctor.setOffice(rs.getString("office"));
                doctorlist.add(doctor);
                for (org.example.domain.doctor value : doctorlist) {
                    System.out.println(value);
                }
                jdbc.closeAll(null, p, null);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return doctorlist;
    }

    public List<doctor> doctor_showall() {
        jdbc jdbc = new jdbc();
        Connection conn = null;
        conn = jdbc.getConn();
        List<doctor> doctorlist = new ArrayList<>();
        try {
            PreparedStatement p = conn.prepareStatement("select username,password,name,sex,phone,office from doctor_log");
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                doctor doctor = new doctor();
                doctor.setUsername(rs.getString("username"));
                doctor.setPassword(rs.getString("password"));
                doctor.setName(rs.getString("name"));
                doctor.setSex(rs.getString("sex"));
                doctor.setPhone(rs.getString("phone"));
                doctor.setOffice(rs.getString("office"));
                doctorlist.add(doctor);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            jdbc.closeAll(null, null, null);
        }
        return doctorlist;
    }

    public List<doctor> doctor_massage() {
        jdbc jdbc = new jdbc();
        Connection conn = null;
        conn = jdbc.getConn();
        List<doctor> doctorlist = new ArrayList<>();
        try {
            PreparedStatement p = conn.prepareStatement("select name,sex,office from doctor_log where state=1");
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                doctor doctor = new doctor();
                doctor.setName(rs.getString("name"));
                doctor.setSex(rs.getString("sex"));
                doctor.setOffice(rs.getString("office"));
                doctorlist.add(doctor);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return doctorlist;
    }

    public void doctor_alter(String sex, String phone, String office, String name) {
        jdbc jdbc = new jdbc();
        Connection conn = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        conn = jdbc.getConn();
        try {
            p = conn.prepareStatement("UPDATE doctor_log set sex=?,phone=?,office=? where name=?");
            p.setString(1, sex);
            p.setString(2, phone);
            p.setString(3, office);
            p.setString(4, name);
            p.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            jdbc.closeAll(null, p, null);
        }
    }

    public void duty(String name) {
        jdbc jdbc = new jdbc();
        Connection conn = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        conn = jdbc.getConn();
        try {
            System.out.println("sql"+name);
            p = conn.prepareStatement("insert into duty (name)values (?)");
            p.setString(1, name);
            p.executeUpdate();
            System.out.println("已执行");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try{
            p=conn.prepareStatement("UPDATE doctor_log SET state=1 WHERE name=?");
            p.setString(1, name);
            p.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.closeAll(null,p,null);
        }
    }
    public void unduty(String name) {
        jdbc jdbc = new jdbc();
        Connection conn = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        conn = jdbc.getConn();
        try {
            System.out.println("sql"+name);
            p = conn.prepareStatement("insert into duty (name)values (?)");
            p.setString(1, name);
            p.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try{
            p=conn.prepareStatement("UPDATE doctor_log SET state=0 WHERE name=?");
            p.setString(1, name);
            p.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.closeAll(null,p,null);
        }
    }

    public List<doctor> duty_show() {
        jdbc jdbc = new jdbc();
        Connection conn = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        conn = jdbc.getConn();
        List<doctor> doctorlist = new ArrayList<>();
        try {
            p=conn.prepareStatement("select * from duty");
            rs=p.executeQuery();
            while (rs.next()) {
                doctor doctor = new doctor();
                doctor.setName(rs.getString("name"));
                doctor.setPhone(rs.getString("time"));
                doctorlist.add(doctor);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }return doctorlist;
    }
    public List<doctor> show_unduty(){
        jdbc jdbc = new jdbc();
        Connection conn = null;
        conn = jdbc.getConn();
        List<doctor> doctorlist = new ArrayList<>();
        try {
            PreparedStatement p = conn.prepareStatement("select name from doctor_log where state=0");
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                doctor doctor = new doctor();
                doctor.setName(rs.getString("name"));
                doctorlist.add(doctor);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            jdbc.closeAll(null, null, null);
        }
        return doctorlist;
    }
    public List<doctor> show_duty(){
        jdbc jdbc = new jdbc();
        Connection conn = null;
        conn = jdbc.getConn();
        List<doctor> doctorlist = new ArrayList<>();
        try {
            PreparedStatement p = conn.prepareStatement("select name from doctor_log where state=1");
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                doctor doctor = new doctor();
                doctor.setName(rs.getString("name"));
                doctorlist.add(doctor);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            jdbc.closeAll(null, null, null);
        }
        return doctorlist;
    }
}
