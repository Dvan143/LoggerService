package org.dmitriyprojects.bankapploggingservice.db;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface LogRepository extends MongoRepository<LogDocument, Long> {
}
