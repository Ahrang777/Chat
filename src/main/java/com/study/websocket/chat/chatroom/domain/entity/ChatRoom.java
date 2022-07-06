package com.study.websocket.chat.chatroom.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@NoArgsConstructor
//@Entity
public class ChatRoom {

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/

    private String roomId;
    private String name;

    public static ChatRoom create(@NonNull String name) {
        ChatRoom created = new ChatRoom();
//        created.id = UUID.randomUUID().toString();
        created.roomId = name;  // Long id 로?
        created.name = name;
        return created;
    }
}
