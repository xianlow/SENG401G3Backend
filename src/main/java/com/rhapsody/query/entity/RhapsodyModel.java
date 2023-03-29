package com.rhapsody.query.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RhapsodyModel {

    @Id
    private String aggregateId;
    private String title;
    private String content;
    private String department;


    public RhapsodyModel(RhapsodyModel rhapsodyModel) {
        this.aggregateId = rhapsodyModel.aggregateId;
        this.title = rhapsodyModel.title;
        this.content = rhapsodyModel.content;
        this.department = rhapsodyModel.department;
    }
}

