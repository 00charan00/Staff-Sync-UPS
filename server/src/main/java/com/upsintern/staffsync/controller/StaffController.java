package com.upsintern.staffsync.controller;

import com.upsintern.staffsync.entity.Staff;
import com.upsintern.staffsync.responsemodel.LoginRegisterResponse;
import com.upsintern.staffsync.responsemodel.ResponseBase;
import com.upsintern.staffsync.dto.StaffDto;
import com.upsintern.staffsync.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("staff")
@CrossOrigin
public class StaffController {

    @Autowired
    StaffService staffService;

    @PostMapping("add")
    public ResponseEntity<LoginRegisterResponse> addNewStaff(@RequestBody StaffDto staffDto){
        LoginRegisterResponse response = new LoginRegisterResponse(staffService.saveNewStaff(staffDto),true, Staff.StaffRole.ROLE_EMPLOYEE);
        return ResponseEntity.ok(response);
    }

    @PutMapping("update/{staffId}")
    public ResponseEntity<ResponseBase> updateStaff(@PathVariable String staffId, @RequestBody StaffDto staffDto){
        ResponseBase response = new ResponseBase(staffService.updateStaff(staffId,staffDto),true);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("del")
    public ResponseEntity<ResponseBase> deleteStaff(@RequestParam String staffId){
        ResponseBase response = new ResponseBase(staffService.deleteStaff(staffId),true);
        return ResponseEntity.ok(response);
    }

    @PostMapping("login")
    public ResponseEntity<LoginRegisterResponse> staffLogin(@RequestBody StaffDto staffDto){
        return ResponseEntity.ok(staffService.staffLogin(staffDto));
    }
}
