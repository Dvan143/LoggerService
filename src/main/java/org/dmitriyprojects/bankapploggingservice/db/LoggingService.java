package org.dmitriyprojects.bankapploggingservice.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class LoggingService {
    @Autowired
    LogRepository logRepository;

    @Transactional
    public void saveLog(LogDto log) {
        LogDocument logDocument = new LogDocument(log.getFrom(), log.getBody(), log.getAdditionalInfo());
        logRepository.save(logDocument);
    }

    @Transactional(readOnly = true)
    public Page<LogDocument> getLogDocumentByPage(String stringPage) {
        int page = Integer.parseInt(stringPage);
        if(page <= 0) page = 1;
        Pageable logs = PageRequest.of(page-1, 10, Sort.by("date").descending());
        return logRepository.findAll(logs);
    }
}
