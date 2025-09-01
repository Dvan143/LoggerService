package org.dmitriyprojects.bankapploggingservice.listeners;

import org.dmitriyprojects.bankapploggingservice.db.LogDto;
import org.dmitriyprojects.bankapploggingservice.db.LoggingService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitConsumer {
    @Autowired
    LoggingService loggingService;

    @RabbitListener(queues = "log-queue")
    public void saveLogs(LogDto log) {
        loggingService.saveLog(log);
    }
}
