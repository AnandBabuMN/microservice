package com.auth.service.config;

import com.auth.service.entity.RoleEnum;
import com.auth.service.entity.User;
import com.auth.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(RoleEnum.ADMIN);
            userRepository.save(admin);
            System.out.println("✅ Default Admin created: admin/admin123");
        }

        if (userRepository.findByUsername("staff").isEmpty()) {
            User staff = new User();
            staff.setUsername("staff");
            staff.setPassword(passwordEncoder.encode("staff123"));
            staff.setRole(RoleEnum.STAFF);
            userRepository.save(staff);
            System.out.println("✅ Default Staff created: staff/staff123");
        }
    }
}


