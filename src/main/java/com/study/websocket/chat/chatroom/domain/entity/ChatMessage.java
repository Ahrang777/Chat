package com.study.websocket.chat.chatroom.domain.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {

    private String chatRoomId;
    private String sender;
    private String message;
}
