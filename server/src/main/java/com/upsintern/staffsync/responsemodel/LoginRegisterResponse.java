package com.upsintern.staffsync.responsemodel;

import com.upsintern.staffsync.entity.Staff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginRegisterResponse{
    String msg;
    boolean status;
    Staff.StaffRole role;
}
