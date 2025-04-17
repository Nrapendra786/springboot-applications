package com.techwaala.ai_assistant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/chat")
@Slf4j
public class ChatController {

    private OrderManagementAIAssistant omAiAssistantConfiguration;

    private final OrderChatAssistant orderChatAssistant;

    private final OrderManagementAIAssistant orderManagementAIAssistant;

    public ChatController(OrderChatAssistant orderChatAssistant, OrderManagementAIAssistant orderManagementAIAssistant) {
        this.orderChatAssistant = orderChatAssistant;
        this.orderManagementAIAssistant = orderManagementAIAssistant;
    }

    @PostMapping("/chat/{prompt}")
    public String chat(@PathVariable("prompt") String promptString) {
        ChatResponse response = this.orderManagementAIAssistant
                .callChatClient(Set.of("createOrderFn"), promptString);
        return response.getResult().getOutput().getText();
    }
}
