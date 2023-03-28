package com.rhapsody.query.entity;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;

@Entity
@Table(name = "posts")
public class RhapsodyModel {

    @Id
    @Column(name = "aggregateid", unique = true, length = 100)
    private String aggregateId;
    @Column(name = "title", length = 50)
    private String title;
    @Column(name = "content", length = 1000)
    private String content;
    public void setId(String id) {
        this.aggregateId = id;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getId() {
        return this.aggregateId;
    }
    public String getContent() {
        return this.content;
    }
    public String getTitle() {
        return this.title;
    }

    @Override
    public String toString() {
        return "RhapsodyModel{" +
                "id='" + aggregateId + '\'' +
                ", title =" + title +
                ", content='" + content + '\'' + '}';
    }
}

