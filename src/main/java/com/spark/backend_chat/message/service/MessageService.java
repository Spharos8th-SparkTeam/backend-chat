package com.spark.backend_chat.message.service;

import com.spark.backend_chat.common.error.BusinessException;
import com.spark.backend_chat.common.error.ErrorCode;
import com.spark.backend_chat.message.dto.request.MessageSendRequest;
import com.spark.backend_chat.message.dto.request.MessageTranslateRequest;
import com.spark.backend_chat.message.dto.response.MessageResponse;
import com.spark.backend_chat.message.dto.response.MessageTranslateResponse;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class MessageService {

    // TODO: Message Document/Repository 연동 후 구현 (#4)
    public List<MessageResponse> getMessages(UUID chatRoomId, UUID memberId) {
        return Collections.emptyList();
    }

    // TODO: Message Document/Repository 연동 후 구현 (#4)
    public MessageResponse sendMessage(UUID chatRoomId, UUID memberId, MessageSendRequest request) {
        throw new BusinessException(ErrorCode.FEATURE_NOT_READY);
    }

    // TODO: 번역 API 연동 후 구현 (#4)
    public MessageTranslateResponse translateMessage(
            UUID messageId,
            UUID memberId,
            MessageTranslateRequest request
    ) {
        throw new BusinessException(ErrorCode.FEATURE_NOT_READY);
    }
}
