package org.jugnicaragua.javagpt.services.models;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;

public class GptChoice {

    private final ChatMessage message;

    private final String finishReason;

    private final Integer index;

    @JsonbCreator
    public GptChoice(
            @JsonbProperty("message") ChatMessage message,
            @JsonbProperty("finish_reason") String finishReason,
            @JsonbProperty("index") Integer index) {
        this.message = message;
        this.finishReason = finishReason;
        this.index = index;
    }

    public ChatMessage getMessage() {
        return message;
    }

    public String getFinishReason() {
        return finishReason;
    }

    public Integer getIndex() {
        return index;
    }
}
