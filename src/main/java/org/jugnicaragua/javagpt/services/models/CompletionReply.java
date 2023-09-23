package org.jugnicaragua.javagpt.services.models;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;

import java.util.ArrayList;

public class CompletionReply {

    private final String id;

    private final String object;

    private final Long created;

    private final String model;

    private final GptUsage usage;

    private final ArrayList<GptChoice> choices;

    @JsonbCreator
    public CompletionReply(
            @JsonbProperty("id") String id,
            @JsonbProperty("object") String object,
            @JsonbProperty("title") Long created,
            @JsonbProperty("model") String model,
            @JsonbProperty("usage") GptUsage usage,
            @JsonbProperty("choices") ArrayList<GptChoice> choices) {
        this.id = id;
        this.object = object;
        this.created = created;
        this.model = model;
        this.usage = usage;
        this.choices = choices;
    }

    public String getId() {
        return id;
    }

    public String getObject() {
        return object;
    }

    public Long getCreated() {
        return created;
    }

    public String getModel() {
        return model;
    }

    public GptUsage getUsage() {
        return usage;
    }

    public ArrayList<GptChoice> getChoices() {
        return choices;
    }
}
