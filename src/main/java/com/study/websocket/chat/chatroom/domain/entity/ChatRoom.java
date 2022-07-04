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
//    private Set<WebSocketSession> sessions = new HashSet<>();

    public static ChatRoom create(@NonNull String name) {
        ChatRoom created = new ChatRoom();
//        created.id = UUID.randomUUID().toString();
        created.roomId = name;  // Long id 로?
        created.name = name;
        return created;
    }

    /*public void handleMessage(WebSocketSession session, ChatMessage chatMessage, ObjectMapper objectMapper) {

        if (chatMessage.getType() == MessageType.JOIN) {
            join(session);
            chatMessage.setMessage(chatMessage.getWriter() + "님이 입장했습니다.");
        }

        send(chatMessage, objectMapper);
    }

    private void join(WebSocketSession session) {
        sessions.add(session);
    }

    private <T> void send(T messageObject, ObjectMapper objectMapper) {
        try {
            TextMessage message = new TextMessage(objectMapper.writeValueAsString(messageObject));
            sessions.parallelStream().forEach(session -> MessageSendUtils.sendMessage(session, message));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public void remove(WebSocketSession target) {

        String targetId = target.getId();
        sessions.removeIf(session -> session.getId().equals(targetId));
    }*/
}
