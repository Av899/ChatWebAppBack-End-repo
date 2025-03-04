package com.av.chatapp.backend.entities;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String sender;
    private String content;
    private LocalDateTime timeStamp;

    public Message(String sender, String content) {
        this.sender = sender;
        this.content = content;
        this.timeStamp = LocalDateTime.now();
    }
}
