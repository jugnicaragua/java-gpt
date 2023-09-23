package org.jugnicaragua.javagpt.services.models;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;

public class GptUsage {

    private final Integer promptTokens;

    private final Integer completionTokens;

    private final Integer totalTokens;



    @JsonbCreator
    public GptUsage(
            @JsonbProperty("prompt_tokens") Integer promptTokens,
            @JsonbProperty("completion_tokens") Integer completionTokens,
            @JsonbProperty("total_tokens") Integer totalTokens) {
        this.promptTokens = promptTokens;
        this.completionTokens = completionTokens;
        this.totalTokens = totalTokens;
    }

    public Integer getPromptTokens() {
        return promptTokens;
    }

    public Integer getCompletionTokens() {
        return completionTokens;
    }

    public Integer getTotalTokens() {
        return totalTokens;
    }
}
