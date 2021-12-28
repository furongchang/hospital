package org.example.domain;

public class medicine {
    private String name;
    private String id;
    private String introduce;

    public medicine() {
    }

    public medicine(String name, String id, String introduce) {
        this.name = name;
        this.id = id;
        this.introduce = introduce;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
