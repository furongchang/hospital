package org.example.domain;

public class log {
    private String time;
    private String ip;
    private String user;
    private String visit;
    private String status;

    public log() {
    }

    public log(String time, String ip, String user, String visit, String status) {
        this.time = time;
        this.ip = ip;
        this.user = user;
        this.visit = visit;
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getVisit() {
        return visit;
    }

    public void setVisit(String visit) {
        this.visit = visit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
