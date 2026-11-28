package com.spark.backend_chat.room.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class ChatRoomCreateRequest {

    @NotNull
    private UUID productId;

    @NotNull
    private UUID sellerId;
}
