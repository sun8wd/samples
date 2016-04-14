package com.celloud.websocket;

import java.util.Date;

public class ChatMessage {
    private Integer id;
    private String username;
    private String message;
    private Date date;

    public ChatMessage(String username, String message) {
        this.username = username;
        this.message = message;
        this.date = new Date();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    

}
