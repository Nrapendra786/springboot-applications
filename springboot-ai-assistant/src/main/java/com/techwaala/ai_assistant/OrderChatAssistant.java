package com.techwaala.ai_assistant;

import com.techwaala.order.OrderRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderChatAssistant {

    private ChatClient chatClient;

    private String PROMPT = "You are an assistant for an Order Management System. " +
            "Users can ask about creating, updating, or tracking orders.";

    @Autowired
    public OrderChatAssistant(ChatClient.Builder chatClient,OrderRepository orderRepository){
        this.chatClient=chatClient.build();
    }

    public String getChatResponse(String userMessage) {
        String context = "User said : ";
        return chatClient.prompt(PROMPT + context + userMessage).call().content();
    }

}
