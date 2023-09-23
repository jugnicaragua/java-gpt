package org.jugnicaragua.javagpt.services.models;

import jakarta.json.bind.annotation.JsonbProperty;

import java.util.List;
import java.util.Map;

public class GptFunctionParameters {

    private final String type = "object";

    private final Map<String, GptFunctionProperty> properties;

    private final List<String> required;

    public GptFunctionParameters(
            final Map<String, GptFunctionProperty> properties,
            final List<String> required) {
        this.properties = properties;
        this.required = required;
    }

    @JsonbProperty
    public String getType() {
        return type;
    }

    @JsonbProperty
    public List<String> getRequired() {
        return required;
    }

    @JsonbProperty
    public Map<String, GptFunctionProperty> getProperties() {
        return properties;
    }
}
