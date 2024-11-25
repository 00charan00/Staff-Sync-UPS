package com.upsintern.staffsync.service;

import com.upsintern.staffsync.repo.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StaffDetailsService implements UserDetailsService {

    @Autowired
    StaffRepo staffRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new StaffDetails(staffRepo.findByStaffEmail(username));
    }
}
