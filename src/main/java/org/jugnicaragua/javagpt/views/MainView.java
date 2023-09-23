package org.jugnicaragua.javagpt.views;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import jakarta.inject.Inject;
import org.jugnicaragua.javagpt.services.ChatSessionService;
import org.jugnicaragua.javagpt.services.models.ChatMessage;

import java.util.stream.Collectors;

@Route("")
public class MainView extends VerticalLayout implements BeforeEnterObserver {

    @Inject
    ChatSessionService chatSessionService;

    private MessageList messageList;

    public MainView() {
        //Crate the container for the chat messages
        messageList = new MessageList();
        messageList.setHeight(100, Unit.PERCENTAGE);
        messageList.getStyle().set("border-radius", "10px");
        messageList.getStyle().set("background-color", "white");
        messageList.getStyle().set("box-shadow", "2px 2px 2px rgba(0,0,0,0.1)");

        //Create the elements to receive inputs from the user
        var messageInput = new MessageInput();
        messageInput.addSubmitListener(this::sendMessage);

        //Add input elements to a parent container
        var header = new H1("Duke GPT");
        header.getStyle().set("text-align", "center");
        add(header, messageList, messageInput);

        //Set container properties
        setAlignItems(Alignment.STRETCH);
        setPadding(true);
        setSpacing(true);
        setHeight(100, Unit.PERCENTAGE);
        getStyle().set("background-color", "#f0efed");

    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        updateMessagesList();
    }

    private void sendMessage(MessageInput.SubmitEvent submitEvent) {
        var message = submitEvent.getValue();
        this.chatSessionService.addUserMessage(message);
        updateMessagesList();

        //Request GPT reply®
        chatSessionService.requestReply();
        updateMessagesList();
    }

    private void updateMessagesList() {
        this.messageList.setItems(chatSessionService.getMessages().stream()
                .filter(m -> ChatMessage.USER_CHAT_ROLE.equalsIgnoreCase(m.getRole())
                        || ChatMessage.ASSISTANT_CHAT_ROLE.equalsIgnoreCase(m.getRole()))
                .map(m -> new MessageListItem(m.getContent(), m.getDate(), m.getRole().toUpperCase()))
                .collect(Collectors.toList()));
    }

}
