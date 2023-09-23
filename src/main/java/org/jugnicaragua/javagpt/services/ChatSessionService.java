package org.jugnicaragua.javagpt.services;

import com.vaadin.cdi.annotation.VaadinSessionScoped;
import jakarta.inject.Inject;
import jakarta.json.bind.JsonbBuilder;
import org.jugnicaragua.javagpt.services.models.ChatMessage;
import org.jugnicaragua.javagpt.services.models.GptChoice;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

@VaadinSessionScoped
public class ChatSessionService {


    @Inject
    private GptService gptService;

    @Inject
    private JugDataService jugDataService;

    private ArrayList<ChatMessage> messages;


    public ChatSessionService() {
        this.gptService = gptService;
        messages = new ArrayList<>();

        //Add an initial system message
        messages.add(new ChatMessage(ChatMessage.SYSTEM_CHAT_ROLE, "No asumas que valores puedes pasar a las" +
                "funciones. Pide aclaraciones si el usuario hace preguntas ambiguas", null, null));
    }

    public void addUserMessage(final String message) {
        this.messages.add(new ChatMessage(ChatMessage.USER_CHAT_ROLE, message, null, null));
    }

    public void requestReply() {
        var reply = this.gptService.requestCompletion(this.messages);
        var jsonB = JsonbBuilder.create();

        for (GptChoice choice: reply.getChoices()) {
            if (choice.getMessage().getFunctionCall() != null) {
                var arguments = choice.getMessage().getFunctionCall().getArguments();
                switch (choice.getMessage().getFunctionCall().getName()) {
                    case JugDataService.FUNCTION_MEMBER_DATA:
                        var mappedArguments = jsonB.fromJson(arguments, Map.class);
                        if (mappedArguments.containsKey("nombre")) {
                            var data = jugDataService.getJugMemberDataByName(mappedArguments.get("nombre").toString());
                            this.messages.add(new ChatMessage(ChatMessage.FUNCTION_CHAT_ROLE, data, null,
                                    JugDataService.FUNCTION_MEMBER_DATA));
                        } else {
                            this.messages.add(new ChatMessage(ChatMessage.FUNCTION_CHAT_ROLE,
                                    "No se recibio ningun nombre de miembro del jug, debes preguntar por el nombre",
                                    null, JugDataService.FUNCTION_MEMBER_DATA));
                        }
                        requestReply();
                        break;
                }
            } else {
                var assistantMessage = choice.getMessage().getContent();
                this.messages.add(new ChatMessage(ChatMessage.ASSISTANT_CHAT_ROLE, assistantMessage, null, null));
            }


        }
    }

    public ArrayList<ChatMessage> getMessages() {
        return messages;
    }
}
