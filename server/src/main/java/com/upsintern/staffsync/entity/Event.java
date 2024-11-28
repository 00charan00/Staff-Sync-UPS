package com.upsintern.staffsync.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    Date eventDate;
    String eventDescription;
}
