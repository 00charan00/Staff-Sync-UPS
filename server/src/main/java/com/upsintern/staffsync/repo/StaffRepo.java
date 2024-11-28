package com.upsintern.staffsync.repo;


import com.upsintern.staffsync.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepo extends JpaRepository<Staff,String> {
    Staff findByStaffEmail(String username);

    boolean existsByStaffEmail(String mail);
}
