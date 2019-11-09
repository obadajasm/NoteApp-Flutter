package com.obadajasem.testapp.modal;

import androidx.annotation.NonNull;

public class post {

    private Integer UserId;
    private Integer id;
    private String title;
    private  String body;

    public post(Integer userId, String title, String body) {
        UserId = userId;
        this.title = title;
        this.body = body;
    }

    public post(String title) {
        this.title = title;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @NonNull
    @Override
    public String toString() {
        return "ID : "+getId()+"\n"
                +"Body"+getBody()+"\n";
    }
}
