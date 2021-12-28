package org.example.domain;

public class patient {
    private String username;
    private String password;
    private String name;
    private String sex;
    private String phone;
    private String id;

    public patient() {
    }

    public patient(String username, String password, String name, String sex, String phone, String id) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.id = id;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
