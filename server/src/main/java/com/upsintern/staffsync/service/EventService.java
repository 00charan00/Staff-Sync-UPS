package com.upsintern.staffsync.service;

import com.upsintern.staffsync.dto.EventDto;
import com.upsintern.staffsync.entity.Event;
import com.upsintern.staffsync.repository.EventRepository;
import com.upsintern.staffsync.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    public String saveNewEvent(EventDto eventDto){
        Event event= Mapper.eventMapper(eventDto);
        return eventRepository.save(event).getEventId();
    }

    public List<Event> getAllEvent(){
        return eventRepository.findAll();
    }
}
