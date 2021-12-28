package org.example.dao;

import org.example.domain.doctor;
import org.example.domain.patient;
import org.example.utils.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class patientDao {
    public List<patient> patient_show(String name){
        jdbc jdbc =new jdbc();
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement p=null;
        conn = jdbc.getConn();
        List<patient> patientList=new ArrayList<>();
        try{
            p = conn.prepareStatement("select username,password,name,sex,phone,id from patient_log where name=?");
            p.setString(1,name);
            rs = p.executeQuery();
            if (rs.next()) {
                patient patient=new patient();
                patient.setUsername(rs.getString("username"));
                patient.setPassword(rs.getString("password"));
                patient.setName(rs.getString("name"));
                patient.setSex(rs.getString("sex"));
                patient.setPhone(rs.getString("phone"));
                patient.setId(rs.getString("id"));
                patientList.add(patient);

                for (org.example.domain.patient value : patientList) {
                    System.out.println(value);
                }
                jdbc.closeAll(rs, p, null);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }return patientList;
    }
    public List<patient> patient_showall(){
        jdbc jdbc =new jdbc();
        Connection conn = null;
        PreparedStatement p=null;
        ResultSet rs=null;
        conn = jdbc.getConn();
        List<patient> patientList=new ArrayList<>();
        try{
            p = conn.prepareStatement("select username,password,name,sex,phone,id from patient_log ");
            rs = p.executeQuery();
            while (rs.next()) {
                patient patient=new patient();
                patient.setUsername(rs.getString("username"));
                patient.setPassword(rs.getString("password"));
                patient.setName(rs.getString("name"));
                patient.setSex(rs.getString("sex"));
                patient.setPhone(rs.getString("phone"));
                patient.setId(rs.getString("id"));
                patientList.add(patient);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.closeAll(rs, p, null);
        }
        return patientList;
    }
    public void patient_alter(String sex,String phone,String id,String name) {
        jdbc jdbc = new jdbc();
        Connection conn = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        conn = jdbc.getConn();
        try {
            p = conn.prepareStatement("UPDATE patient_log set sex=?,phone=?,id=? where name=?");
            p.setString(1,sex);
            p.setString(2,phone);
            p.setString(3,id);
            p.setString(4,name);
            p.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.closeAll(null,p,null);
        }
    }
}
