package com.better.domain;

import java.io.Serializable;

public class Cat implements Serializable {
    private Integer cat_id;
    private String cat_name,cat_img,cat_eat,cat_status;

    public Integer getCat_id() {
        return cat_id;
    }

    public void setCat_id(Integer cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public String getCat_img() {
        return cat_img;
    }

    public void setCat_img(String cat_img) {
        this.cat_img = cat_img;
    }

    public String getCat_eat() {
        return cat_eat;
    }

    public void setCat_eat(String cat_eat) {
        this.cat_eat = cat_eat;
    }

    public String getCat_status() {
        return cat_status;
    }

    public void setCat_status(String cat_status) {
        this.cat_status = cat_status;
    }
}
