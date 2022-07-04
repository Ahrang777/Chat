package com.study.websocket.chat.chatroom.api;

import com.study.websocket.chat.chatroom.domain.entity.ChatMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ChatMessageController {

    private final SimpMessagingTemplate template;

    @MessageMapping("/chat/join")
    public void join(ChatMessage message) {
        log.info("call join method");
        message.setMessage(message.getWriter() + "님이 입장하셨습니다.");

        log.info("message content : {}", message.getMessage());

        template.convertAndSend("/subscribe/chat/room/" + message.getChatRoomId(), message);
    }

    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        log.info("call message method");
        log.info("message content : {}", message.getMessage());

        template.convertAndSend("/subscribe/chat/room/" + message.getChatRoomId(), message);
    }
}
