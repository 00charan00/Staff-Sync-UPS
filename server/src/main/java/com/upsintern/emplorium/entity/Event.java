package com.upsintern.emplorium.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Event {
    @Id
    String eventId;
    String eventName;
    String eventVenue;
    @Temporal(TemporalType.TIMESTAMP) // Ensures correct mapping to DATETIME in DB
    private Date eventDate;
    String eventDescription;
}
