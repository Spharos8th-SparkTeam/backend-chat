package com.spark.backend_chat.message.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class MessageSendRequest {

    @Size(max = 2000)
    private String content;

    @Size(max = 10)
    private List<String> mediaKeys = new ArrayList<>();
}
