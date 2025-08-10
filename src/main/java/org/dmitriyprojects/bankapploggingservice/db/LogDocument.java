package org.dmitriyprojects.bankapploggingservice.db;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document(indexName = "logs")
public class LogDocument {
    @Id
    private Long id;
    private String date;
    private String from;
    private String body;
    private String additionalInfo;

    public LogDocument() {
    }

    public LogDocument(String from, String body, String additionalInfo) {
        LocalDateTime date = LocalDateTime.now();
        this.date = date.toString();

        this.from = from;
        this.body = body;
        this.additionalInfo = additionalInfo;
    }
}
