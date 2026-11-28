package com.spark.backend_chat.room.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class ChatRoomCreateResponse {

    private UUID chatRoomId;
    private UUID productId;
    private UUID sellerId;
    private UUID buyerId;
}
