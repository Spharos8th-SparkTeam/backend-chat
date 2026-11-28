package com.spark.backend_chat.message.controller;

import com.spark.backend_chat.common.error.BusinessException;
import com.spark.backend_chat.common.error.ErrorCode;
import com.spark.backend_chat.message.dto.request.MessageSendRequest;
import com.spark.backend_chat.message.dto.request.MessageTranslateRequest;
import com.spark.backend_chat.message.dto.response.MessageResponse;
import com.spark.backend_chat.message.dto.response.MessageTranslateResponse;
import com.spark.backend_chat.message.service.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Tag(name = "Message", description = "채팅 메시지 API")
@RestController
@RequestMapping("/api/v1/chats")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @Operation(summary = "메시지 목록 조회")
    @GetMapping("/{chatRoomId}/messages")
    public ResponseEntity<List<MessageResponse>> getMessages(
            @PathVariable UUID chatRoomId,
            @RequestHeader("X-Member-UUID") UUID memberId
    ) {
        validateMemberId(memberId);
        return ResponseEntity.ok(messageService.getMessages(chatRoomId, memberId));
    }

    @Operation(summary = "메시지 전송")
    @PostMapping("/{chatRoomId}/messages")
    public ResponseEntity<MessageResponse> sendMessage(
            @PathVariable UUID chatRoomId,
            @RequestHeader("X-Member-UUID") UUID memberId,
            @Valid @RequestBody MessageSendRequest request
    ) {
        validateMemberId(memberId);
        return ResponseEntity.ok(messageService.sendMessage(chatRoomId, memberId, request));
    }

    @Operation(summary = "메시지 번역")
    @PostMapping("/messages/{messageId}/translate")
    public ResponseEntity<MessageTranslateResponse> translateMessage(
            @PathVariable UUID messageId,
            @RequestHeader("X-Member-UUID") UUID memberId,
            @Valid @RequestBody MessageTranslateRequest request
    ) {
        validateMemberId(memberId);
        return ResponseEntity.ok(messageService.translateMessage(messageId, memberId, request));
    }

    private void validateMemberId(UUID memberId) {
        if (memberId == null) {
            throw new BusinessException(ErrorCode.MISSING_MEMBER_UUID);
        }
    }
}
