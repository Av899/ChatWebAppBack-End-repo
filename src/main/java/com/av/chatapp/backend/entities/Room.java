package com.av.chatapp.backend.entities;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "rooms")
public class Room {

    private String id;//MongoDB unique identifier
    private String roomId;
    private List<Message> messages= new ArrayList<>();

}
