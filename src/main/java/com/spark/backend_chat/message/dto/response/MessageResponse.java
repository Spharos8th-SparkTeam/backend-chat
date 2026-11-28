package com.spark.backend_chat.message.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class MessageResponse {

    private UUID messageId;
    private UUID chatRoomId;
    private UUID senderId;
    private String content;
    private List<String> mediaKeys;
    private LocalDateTime createdAt;
}
