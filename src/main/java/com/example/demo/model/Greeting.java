package com.example.demo.model;

public class Greeting {
    private long id;
    private String content;

    public Greeting() {
        // Default constructor
        this.id = 0;
        this.content = "";
    }

    public long getId() { 
        return id; 
    }

    public void setId(long id) { 
        this.id = id; 
    }

    public String getContent() { 
        return content != null ? content : ""; 
    }

    public void setContent(String content) { 
        this.content = content != null ? content : ""; 
    }
}