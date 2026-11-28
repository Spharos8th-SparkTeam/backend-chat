package com.spark.backend_chat.room.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class ChatRoomLeaveResponse {

    private UUID chatRoomId;
    private boolean left;
}
