package com.spark.backend_chat.message.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class MessageTranslateResponse {

    private UUID messageId;
    private String targetLanguage;
    private String translatedContent;
}
