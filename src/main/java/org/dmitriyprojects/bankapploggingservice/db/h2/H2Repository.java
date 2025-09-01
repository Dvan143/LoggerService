package org.dmitriyprojects.bankapploggingservice.db.h2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface H2Repository extends CrudRepository<User, Byte> {
    Optional<User> getByUsername(String username);
}
