package com.rhapsody.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import com.rhapsody.model.AccessDatabase;
import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;

@Entity
@Table(name = "EVENTS")
public class RhapsodyModel {
    //private AccessDatabase access = new AccessDatabase("jdbc:mysql://127.0.0.1:3306/EVENTS", "test", "password");

    @Id
    @Column(name = "eventId", unique = true, length = 100)
    private String eventId;

    @Column(name = "timeStamp", length = 25)
    private String timeStamp;

    @Column(name = "aggregateId")
    private String aggregateId;

    public RhapsodyModel() {
        //access.initializeConnection();
    }
    public RhapsodyModel(String eventId, String timeStamp, String aggregateId) {
        this.eventId = eventId;
        this.timeStamp = timeStamp;
        this.aggregateId = aggregateId;
        //access.initializeConnection();
    }
    public String getEventId() {
        return eventId;
    }
    public String getAggregateId() {
        return aggregateId;
    }
    public String getTimeStamp() {
        String date = LocalDate.now().toString();
        return date;
    }
    public void updatePost(String aggregateId) {
        this.aggregateId = aggregateId;
    }
    @Override
    public String toString() {
        return "Tester [ eventId=" + eventId + ", timeStamp=" + timeStamp + ", aggregateId=" + aggregateId + "]";
    }
}

