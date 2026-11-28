package com.spark.backend_chat.message.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MessageTranslateRequest {

    @NotBlank
    @Size(max = 16)
    private String targetLanguage;
}
