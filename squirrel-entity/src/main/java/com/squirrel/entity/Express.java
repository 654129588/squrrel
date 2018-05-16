package com.squirrel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Express {

    private Long id;

    private String expressName;

    private String expressCode;

    public Express(Long id, String expressName, String expressCode) {
        super();
        this.id = id;
        this.expressName = expressName;
        this.expressCode = expressCode;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    public String getExpressCode() {
        return expressCode;
    }

    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode;
    }

    @Override
    public String toString() {
        return "Express{" +
                "id=" + id +
                ", expressName='" + expressName + '\'' +
                ", expressCode='" + expressCode + '\'' +
                '}';
    }
}
