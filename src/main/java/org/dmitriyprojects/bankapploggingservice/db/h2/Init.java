package org.dmitriyprojects.bankapploggingservice.db.h2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Init {
    @Autowired
    H2Repository h2Repository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        User user = new User("admin1234", passwordEncoder.encode("admin1234"), "ADMIN");
        h2Repository.save(user);
    }
}
