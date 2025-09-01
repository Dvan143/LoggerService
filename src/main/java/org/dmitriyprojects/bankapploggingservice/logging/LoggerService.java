package org.dmitriyprojects.bankapploggingservice.logging;

import org.dmitriyprojects.bankapploggingservice.db.LogDto;
import org.dmitriyprojects.bankapploggingservice.db.LoggingService;
import org.dmitriyprojects.bankapploggingservice.logs.BankAppSecurityLog;
import org.dmitriyprojects.bankapploggingservice.logs.SocialMediaSecurityLog;
import org.dmitriyprojects.bankapploggingservice.logs.WrongPasswordLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerService {
    @Autowired
    LoggingService loggingService;

    public void saveNewLog(WrongPasswordLog log) {
        LogDto<WrongPasswordLog> logObject = new LogDto<>(log);
        loggingService.saveLog(logObject);
    }

    public void saveNewLog(BankAppSecurityLog log) {
        LogDto<BankAppSecurityLog> logObject = new LogDto<>(log);
        loggingService.saveLog(logObject);
    }

    public void saveNewLog(SocialMediaSecurityLog log) {
        LogDto<SocialMediaSecurityLog> logObject = new LogDto<>(log);
        loggingService.saveLog(logObject);
    }
}
