package org.example.domain;

public class prescription {
    private String dname;
    private String pname;
    private String prescription;
    private String time;
    private int id;

    public prescription() {
    }


    public prescription(String dname, String pname, String prescription, String time, int id) {
        this.dname = dname;
        this.pname = pname;
        this.prescription = prescription;
        this.time = time;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
