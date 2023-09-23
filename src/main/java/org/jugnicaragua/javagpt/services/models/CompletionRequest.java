package org.jugnicaragua.javagpt.services.models;

import jakarta.json.bind.annotation.JsonbProperty;
import org.jugnicaragua.javagpt.services.JugDataService;

import java.util.*;

public class CompletionRequest {

    private final ArrayList<ChatMessage> messages;

    private final Float temperature;

    private final List<GptFunction> functions;

    public CompletionRequest(ArrayList<ChatMessage> messages) {
        this.messages = messages;
        this.temperature = 0.78F;

        var functionProperties = new HashMap<String, GptFunctionProperty>();
        functionProperties.put("nombre",
                new GptFunctionProperty("string", "El nombre del miembro del JUG. Ejemplo: Mario"));

//        this.functions = null;
        this.functions = Arrays.asList(new GptFunction(
                JugDataService.FUNCTION_MEMBER_DATA,
                "Devuelve los datos de los miembros del JUG de Nicaragua",
                new GptFunctionParameters(functionProperties, Arrays.asList("nombre"))));
    }

    @JsonbProperty
    public String getModel() {
        return "gpt-3.5-turbo";
    }

    @JsonbProperty
    public ArrayList<ChatMessage> getMessages() {
        return messages;
    }

    @JsonbProperty
    public Float getTemperature() {
        return temperature;
    }

    @JsonbProperty
    public List<GptFunction> getFunctions() {
        return functions;
    }
}
