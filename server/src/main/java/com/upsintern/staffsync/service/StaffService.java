package com.upsintern.staffsync.service;

import com.upsintern.staffsync.dto.StaffDto;
import com.upsintern.staffsync.entity.Staff;
import com.upsintern.staffsync.exception.StaffNotFoundException;
import com.upsintern.staffsync.repo.StaffRepo;
import com.upsintern.staffsync.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.PasswordAuthentication;

@Service
public class StaffService {

    @Autowired
    StaffRepo staffRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    public String saveNewStaff(StaffDto staffDto){
        Staff staff = Mapper.staffMapper(staffDto);
        staff.setStaffPass(passwordEncoder.encode(staff.getStaffPass()));
        return staffRepo.save(staff).getStaffId();
    }

    public String deleteStaff(String staffId){
        staffRepo.deleteById(staffId);
        return "Staff Removed";
    }

    public String updateStaff(String staffId, StaffDto staffDto){
        Staff staff = staffRepo.findById(staffId).orElseThrow(() -> new StaffNotFoundException("No Staff Found with Id: "+staffId));
        String tempVal = staffDto.getStaffEmail();
        if(tempVal != null && !tempVal.isEmpty()){
            staff.setStaffEmail(tempVal);
        }
        tempVal = staffDto.getStaffName();
        if(tempVal != null && !tempVal.isEmpty()){
            staff.setStaffName(tempVal);
        }
        tempVal = staffDto.getStaffPass();
        if(tempVal != null && !tempVal.isEmpty()){
            staff.setStaffPass(tempVal);
        }
        staffRepo.save(staff);
        return "Staff data updated";
    }

}
