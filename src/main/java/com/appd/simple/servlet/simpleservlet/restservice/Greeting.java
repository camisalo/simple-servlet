package com.appd.simple.servlet.simpleservlet.restservice;

public class Greeting {

    private long id;
    private String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String setId(long id) {
        this.id = id;
        return Long.toString(id);
    }

    public String getIdString() {
        return Long.toString(this.id);
    }

    public String getContent() {
        return content;
    }
}
