package com.study.websocket.chat.chatroom.domain.entity;

import lombok.Getter;

import javax.persistence.Entity;

@Getter
@Entity
public class Member {

    private String username;
}
