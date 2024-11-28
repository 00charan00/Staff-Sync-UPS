package com.upsintern.staffsync.utils;

import com.upsintern.staffsync.dto.EventDto;
import com.upsintern.staffsync.dto.StaffDto;
import com.upsintern.staffsync.entity.Event;
import com.upsintern.staffsync.entity.Staff;
import java.util.UUID;

public class Mapper {

    public static Staff staffMapper(StaffDto staffDto){
        return new Staff(
                "Staff:"+UUID.randomUUID(),
                staffDto.getStaffName(),
                staffDto.getStaffEmail(),
                staffDto.getStaffPass(),
                Staff.StaffRole.ROLE_EMPLOYEE
        );
    }

    public static Event eventMapper(EventDto eventDto ){
        return new Event(
                "Event:"+ UUID.randomUUID(),
                eventDto.getEventName(),
                eventDto.getEventVenue(),
                eventDto.getEventDate(),
                eventDto.getEventDescription()
        );
    }
}
