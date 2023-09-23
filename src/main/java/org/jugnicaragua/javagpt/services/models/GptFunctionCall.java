package org.jugnicaragua.javagpt.services.models;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;

public class GptFunctionCall {

    private final String name;

    private final String arguments;

    @JsonbCreator
    public GptFunctionCall(
            @JsonbProperty("name") final String name,
            @JsonbProperty("arguments") final String arguments) {
        this.name = name;
        this.arguments = arguments;
    }

    public String getName() {
        return name;
    }

    public String getArguments() {
        return arguments;
    }
}
