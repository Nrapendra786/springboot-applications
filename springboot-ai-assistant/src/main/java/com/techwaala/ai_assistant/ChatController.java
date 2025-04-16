package com.techwaala.ai_assistant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/chat")
@Slf4j
public class ChatController {

    private OrderManagementAIAssistant omAiAssistantConfiguration;

    private static String PROMPT_STRING = "Create an order with quantity 20 for user id Jenny, and\n" +
            "randomly generate a positive whole number for the order ID";

    public ChatController(OrderManagementAIAssistant omAiAssistant){
        this.omAiAssistantConfiguration = omAiAssistant;
    }

    @PostMapping("/")
    public ResponseEntity<?> chat() {
        ChatResponse response = this.omAiAssistantConfiguration
                .callChatClient(Set.of("createOrderFn"), PROMPT_STRING);
        String resultContent = response.getResult().getOutput().getText();
        log.info("The response from the LLM service: {}", resultContent);
        return  ResponseEntity.ok().body(resultContent);
    }
}
