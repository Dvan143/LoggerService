package org.dmitriyprojects.bankapploggingservice.logs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogParent {
    protected String from;
    protected String body;
    protected String additionalInfo;

    public LogParent() {
    }
}
