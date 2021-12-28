package org.example.domain;

public class doctor {
    private String username;
    private String password;
    private String name;
    private String sex;
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String office;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public doctor(String username, String password, String name, String sex, String phone, String office) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.office = office;
    }

    @Override
    public String toString() {
        return "doctor{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", office='" + office + '\'' +
                '}';
    }

    public doctor() {
    }
}
