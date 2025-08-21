package org.dmitriyprojects.bankapploggingservice.db;

import lombok.Getter;
import lombok.Setter;
import org.dmitriyprojects.bankapploggingservice.logs.LogParent;
import org.springframework.stereotype.Component;


@Component
@Getter
@Setter
public class LogDto<T extends LogParent> {
    private String from;
    private String body;
    private String additionalInfo;

    public LogDto() {
    }

    public LogDto(T log) {
        from = log.getFrom();
        body = log.getBody();
        additionalInfo = log.getBody();
    }

    public LogDto(String from, String body, String additionalInfo) {
        this.from = from;
        this.body = body;
        this.additionalInfo = additionalInfo;
    }

    @Override
    public String toString() {
        return from + body + additionalInfo;
    }
}
