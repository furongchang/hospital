package org.example.domain;

public class office {
    private String id;
    private String name;
    private String introduce;

    public office() {
    }

    public office(String id, String name, String introduce) {
        this.id = id;
        this.name = name;
        this.introduce = introduce;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
