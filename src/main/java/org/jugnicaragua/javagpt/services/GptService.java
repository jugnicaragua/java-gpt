package org.jugnicaragua.javagpt.services;

import com.vaadin.cdi.annotation.VaadinSessionScoped;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import org.jugnicaragua.javagpt.services.models.CompletionReply;
import org.jugnicaragua.javagpt.services.models.CompletionRequest;
import org.jugnicaragua.javagpt.services.models.ChatMessage;

import java.util.ArrayList;

@VaadinSessionScoped
public class GptService {

    private final String openIABaseUrl = "https://api.openai.com/v1/chat/completions";
    private final String key = "";


    public CompletionReply requestCompletion(ArrayList<ChatMessage> messages) {
        var client = ClientBuilder.newClient();
        var jsonB = JsonbBuilder.create();
        String requestBody = jsonB.toJson(new CompletionRequest(messages));

        var target = client.target(openIABaseUrl);
        var response = target.request()
                .header("Authorization", "Bearer " + key)
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .post(Entity.entity(requestBody, MediaType.APPLICATION_JSON_TYPE));

        var responseEntity = response.readEntity(CompletionReply.class);

        response.close();
        client.close();

        return responseEntity;
    }

}
