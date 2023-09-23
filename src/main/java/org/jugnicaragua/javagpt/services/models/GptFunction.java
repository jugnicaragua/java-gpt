package org.jugnicaragua.javagpt.services.models;

import jakarta.json.bind.annotation.JsonbProperty;

public class GptFunction {

    private final String name;

    private final String description;

    private final GptFunctionParameters parameters;

    public GptFunction(String name, String description, GptFunctionParameters parameters) {
        this.name = name;
        this.description = description;
        this.parameters = parameters;
    }

    @JsonbProperty
    public String getName() {
        return name;
    }

    @JsonbProperty
    public String getDescription() {
        return description;
    }

    @JsonbProperty
    public GptFunctionParameters getParameters() {
        return parameters;
    }
}
