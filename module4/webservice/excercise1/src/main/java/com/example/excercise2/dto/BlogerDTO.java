package com.example.excercise2.dto;

import com.example.excercise2.model.Category;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

public class BlogerDTO {
    private int id;
    private String name;
    private String content;
    private String image;
    private Date date;
    private int deleteStatus;

    private Category category;

    public Category getCategory() {
        return category;
    }

    public BlogerDTO(int id, String name, String content, String image, Date date, Category category) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.image = image;
        this.date = date;
        this.category = category;
    }

    public BlogerDTO(int id, String name, String content, String image, Date date, Category category, int deleteStatus) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.image = image;
        this.date = date;
        this.category = category;
        this.deleteStatus = deleteStatus;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BlogerDTO() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}

