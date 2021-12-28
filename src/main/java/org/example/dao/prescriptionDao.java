package org.example.dao;

import org.example.domain.prescription;
import org.example.utils.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class prescriptionDao {
    public void prescription(String dname,String pname,String prescription){
        jdbc jdbc =new jdbc();
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement p=null;
        conn = jdbc.getConn();
        System.out.println("sql连接池已打开");
        try{
            p=conn.prepareStatement("insert into prescription(dname,pname,prescription) values (?,?,?)");
            p.setString(1,dname);
            p.setString(2,pname);
            p.setString(3,prescription);
            p.execute();
            System.out.println("success");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.closeAll(null,p,null);
        }
    }
    public List<prescription> view_prescription(String pname){
        jdbc jdbc =new jdbc();
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement p=null;
        List<prescription> prescriptions=new ArrayList<>();
        conn = jdbc.getConn();
        System.out.println("sql连接池已打开");
        try{
            p=conn.prepareStatement("select * from prescription where pname=?");
            p.setString(1,pname);
            rs=p.executeQuery();
            while (rs.next()) {
                prescription prescription = new prescription();
                prescription.setPname(rs.getString("pname"));
                prescription.setDname(rs.getString("dname"));
                prescription.setPrescription(rs.getString("prescription"));
                prescription.setTime(rs.getString("time"));
                prescription.setId(rs.getInt("id"));
                prescriptions.add(prescription);
            }System.out.println("success");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.closeAll(null,p,null);
        }return prescriptions;
    }
    public List<prescription> view_all_prescription(){
        jdbc jdbc =new jdbc();
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement p=null;
        List<prescription> prescriptions=new ArrayList<>();
        conn = jdbc.getConn();
        System.out.println("sql连接池已打开");
        try{
            p=conn.prepareStatement("select * from prescription");
            rs=p.executeQuery();
            while (rs.next()) {
                prescription prescription = new prescription();
                prescription.setPname(rs.getString("pname"));
                prescription.setDname(rs.getString("dname"));
                prescription.setPrescription(rs.getString("prescription"));
                prescription.setTime(rs.getString("time"));
                prescriptions.add(prescription);
                System.out.println("success");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.closeAll(null,p,null);
        }return prescriptions;
    }
    public String[] random(){

        String [] words = {"枸杞,","山楂,","玄参,","当归,","菟丝,","怀山,","生地,","黄精,","白灼,"};
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        for(int i = 0; i < words.length; i++){
            String word=words[i];
            int index = r.nextInt(9);
            words[index]=word;
        }return words;
    }
}
