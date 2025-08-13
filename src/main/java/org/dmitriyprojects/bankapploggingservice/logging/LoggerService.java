package org.dmitriyprojects.bankapploggingservice.logging;

import org.dmitriyprojects.bankapploggingservice.db.LogDto;
import org.dmitriyprojects.bankapploggingservice.logs.BankAppSecurityLog;
import org.dmitriyprojects.bankapploggingservice.logs.SocialMediaSecurityLog;
import org.dmitriyprojects.bankapploggingservice.logs.WrongPasswordLog;
import org.springframework.stereotype.Service;

@Service
public class LoggerService {
    public void saveNewLog(WrongPasswordLog log) {
        LogDto<WrongPasswordLog> logObject = new LogDto<>();
        logObject.saveLog(log);
    }

    public void saveNewLog(BankAppSecurityLog log) {
        LogDto<BankAppSecurityLog> logObject = new LogDto<>();
        logObject.saveLog(log);
    }

    public void saveNewLog(SocialMediaSecurityLog log) {
        LogDto<SocialMediaSecurityLog> logObject = new LogDto<>();
        logObject.saveLog(log);
    }
}
