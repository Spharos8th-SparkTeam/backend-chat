package com.spark.backend_chat.room.service;

import com.spark.backend_chat.common.error.BusinessException;
import com.spark.backend_chat.common.error.ErrorCode;
import com.spark.backend_chat.room.dto.request.ChatRoomCreateRequest;
import com.spark.backend_chat.room.dto.response.ChatRoomCreateResponse;
import com.spark.backend_chat.room.dto.response.ChatRoomLeaveResponse;
import com.spark.backend_chat.room.dto.response.ChatRoomSummaryResponse;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class ChatRoomService {

    // TODO: ChatRoom Document/Repository 연동 후 구현 (#4)
    public List<ChatRoomSummaryResponse> getChatRooms(UUID memberId) {
        return Collections.emptyList();
    }

    // TODO: ChatRoom Document/Repository 연동 후 구현 (#4)
    public ChatRoomCreateResponse createChatRoom(UUID memberId, ChatRoomCreateRequest request) {
        throw new BusinessException(ErrorCode.FEATURE_NOT_READY);
    }

    // TODO: ChatRoom Document/Repository 연동 후 구현 (#4)
    public ChatRoomLeaveResponse leaveChatRoom(UUID chatRoomId, UUID memberId) {
        throw new BusinessException(ErrorCode.FEATURE_NOT_READY);
    }
}
