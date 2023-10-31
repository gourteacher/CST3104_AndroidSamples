package com.cst3104.samples;

public class Message{
    String messageTyped;
    String timeSent;

    public Message(String messageTyped, String timeSent) {
        this.messageTyped = messageTyped;
        this.timeSent = timeSent;
    }

    public String getMessageTyped() {
        return messageTyped;
    }

    public String getTimeSent() {
        return timeSent;
    }
}