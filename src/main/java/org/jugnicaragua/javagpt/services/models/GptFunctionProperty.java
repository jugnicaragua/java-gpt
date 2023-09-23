package org.jugnicaragua.javagpt.services.models;

import jakarta.json.bind.annotation.JsonbProperty;

public class GptFunctionProperty {

    private final String type;

    private final String description;

    public GptFunctionProperty(String type, String description) {
        this.type = type;
        this.description = description;
    }

    @JsonbProperty
    public String getType() {
        return type;
    }

    @JsonbProperty
    public String getDescription() {
        return description;
    }
}
