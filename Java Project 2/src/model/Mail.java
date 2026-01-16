package model;

import enums.Priority;

import java.util.Date;

public class Mail {
    private final String sender;
    private final Date timestamp;
    private final String content;
    private final Priority priority;

    public Mail(String sender, String content, Priority priority) {
        this.sender = sender;
        this.content = content;
        this.priority = priority;
        this.timestamp = new Date();
    }

    public String getSender() {
        return sender;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getContent() {
        return content;
    }

    public Priority getPriority() {
        return priority;
    }
}
