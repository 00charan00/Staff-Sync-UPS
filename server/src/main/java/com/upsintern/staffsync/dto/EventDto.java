package com.upsintern.staffsync.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
    String eventName;
    String eventVenue;
    Date eventDate;
    String eventDescription;
}
