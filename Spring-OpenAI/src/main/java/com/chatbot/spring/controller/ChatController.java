package com.chatbot.spring.controller;

import com.chatbot.spring.service.OpenAiChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final OpenAiChatService chatService;

    @Autowired
    public ChatController(OpenAiChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/chat")
    public String chatWithBot(@RequestBody String userInput) {
        return chatService.getChatResponse(userInput);
    }
}
