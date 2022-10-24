package com.example.excercise2.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Bloger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String content;
    private String image;
    private Date date;
    private int deleteStatus;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public Bloger(int id, String name, String content, String image, Date date, Category category) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.image = image;
        this.date = date;
        this.category = category;
    }

    public Bloger(int id, String name, String content, String image, Date date, Category category, int deleteStatus) {
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

    public Bloger() {
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
