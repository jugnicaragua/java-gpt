package org.jugnicaragua.javagpt.services.models;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTransient;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class ChatMessage {
    public static final String USER_CHAT_ROLE = "user";
    public static final String SYSTEM_CHAT_ROLE = "system";
    public static final String ASSISTANT_CHAT_ROLE = "assistant";

    public static final String FUNCTION_CHAT_ROLE = "function";

    private final String role;

    private final String content;

    private final Instant date;

    private final GptFunctionCall functionCall;

    private final String name;


    @JsonbCreator
    public ChatMessage(
            @JsonbProperty("role") String role,
            @JsonbProperty("content") String content,
            @JsonbProperty("function_call") GptFunctionCall functionCall,
            @JsonbProperty("name") String name
    ) {
        this.role = role;
        this.content = content;
        this.functionCall = functionCall;
        this.name = name;
        this.date = LocalDateTime.now().toInstant(ZoneOffset.UTC);
    }

    @JsonbProperty
    public String getRole() {
        return role;
    }

    @JsonbProperty
    public String getContent() {
        return content;
    }

    @JsonbProperty
    public GptFunctionCall getFunctionCall() {
        return functionCall;
    }

    @JsonbTransient
    public Instant getDate() {
        return date;
    }

    @JsonbProperty
    public String getName() {
        return name;
    }
}
