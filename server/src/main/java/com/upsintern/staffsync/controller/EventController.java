package com.upsintern.staffsync.controller;

import com.upsintern.staffsync.dto.EventDto;
import com.upsintern.staffsync.entity.Event;
import com.upsintern.staffsync.responsemodel.ResponseBase;
import com.upsintern.staffsync.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("event")
public class EventController {

    @Autowired
    EventService eventService;

    @PostMapping("addEvent")
    public ResponseEntity<ResponseBase> addEvent(@RequestBody EventDto eventDto){
        ResponseBase response = new ResponseBase(eventService.saveNewEvent(eventDto),true);
        return ResponseEntity.ok(response);
    }

    @GetMapping("getEvent")
    public ResponseEntity<List<Event>> getEvent(@RequestBody EventDto eventDto){
        return ResponseEntity.ok(eventService.getAllEvent());
    }

}
