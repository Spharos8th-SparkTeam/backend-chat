package com.spark.backend_chat.room.controller;

import com.spark.backend_chat.common.error.BusinessException;
import com.spark.backend_chat.common.error.ErrorCode;
import com.spark.backend_chat.room.dto.request.ChatRoomCreateRequest;
import com.spark.backend_chat.room.dto.response.ChatRoomCreateResponse;
import com.spark.backend_chat.room.dto.response.ChatRoomLeaveResponse;
import com.spark.backend_chat.room.dto.response.ChatRoomSummaryResponse;
import com.spark.backend_chat.room.service.ChatRoomService;
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

@Tag(name = "ChatRoom", description = "채팅방 API")
@RestController
@RequestMapping("/api/v1/chats")
@RequiredArgsConstructor
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    @Operation(summary = "채팅방 목록 조회")
    @GetMapping
    public ResponseEntity<List<ChatRoomSummaryResponse>> getChatRooms(
            @RequestHeader("X-Member-UUID") UUID memberId
    ) {
        validateMemberId(memberId);
        return ResponseEntity.ok(chatRoomService.getChatRooms(memberId));
    }

    @Operation(summary = "채팅방 생성")
    @PostMapping
    public ResponseEntity<ChatRoomCreateResponse> createChatRoom(
            @RequestHeader("X-Member-UUID") UUID memberId,
            @Valid @RequestBody ChatRoomCreateRequest request
    ) {
        validateMemberId(memberId);
        return ResponseEntity.ok(chatRoomService.createChatRoom(memberId, request));
    }

    @Operation(summary = "채팅방 나가기")
    @PostMapping("/{chatRoomId}/leave")
    public ResponseEntity<ChatRoomLeaveResponse> leaveChatRoom(
            @PathVariable UUID chatRoomId,
            @RequestHeader("X-Member-UUID") UUID memberId
    ) {
        validateMemberId(memberId);
        return ResponseEntity.ok(chatRoomService.leaveChatRoom(chatRoomId, memberId));
    }

    private void validateMemberId(UUID memberId) {
        if (memberId == null) {
            throw new BusinessException(ErrorCode.MISSING_MEMBER_UUID);
        }
    }
}
