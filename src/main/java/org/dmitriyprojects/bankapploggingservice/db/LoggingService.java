package org.dmitriyprojects.bankapploggingservice.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggingService {
    @Autowired
    LogRepository logRepository;

    public void saveLog(LogDto log) {
        LogDocument logDocument = new LogDocument(log.getFrom(), log.getBody(), log.getAdditionalInfo());
        logRepository.save(logDocument);
    }
}
