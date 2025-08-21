package org.dmitriyprojects.bankapploggingservice.db;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Document
public class LogDocument {
    @Id
    private String id;
    private String date;
    private String from;
    private String body;
    private String additionalInfo;

    public LogDocument() {
    }

    public LogDocument(String from, String body, String additionalInfo) {
        ZonedDateTime currentTime = ZonedDateTime.now(ZoneId.of("UTC+3"));
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        this.date = currentTime.format(date);

        this.from = from;
        this.body = body;
        this.additionalInfo = additionalInfo;
    }
}
