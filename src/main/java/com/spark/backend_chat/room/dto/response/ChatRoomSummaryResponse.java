package com.spark.backend_chat.room.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
public class ChatRoomSummaryResponse {

    private UUID chatRoomId;
    private UUID productId;
    private UUID counterpartMemberId;
    private String lastMessagePreview;
    private LocalDateTime lastMessageAt;
}
