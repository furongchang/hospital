package org.example.domain;

public class registration {
    private String dname;
    private String pname;
    private String massage;
    private String time;

    public registration() {
    }

    public registration(String dname, String pname, String massage, String time) {
        this.dname = dname;
        this.pname = pname;
        this.massage = massage;
        this.time = time;
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

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
