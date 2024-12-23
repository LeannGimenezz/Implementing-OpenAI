package com.chatbot.spring.service;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OpenAiChatService {

    private final OpenAiService openAiService;

    public OpenAiChatService(@Value("${openai.api.key}") String apiKey) {
        this.openAiService = new OpenAiService(apiKey);
    }

    public String getChatResponse(String userInput) {
        try {
            CompletionRequest request = CompletionRequest.builder()
                    .model("text-davinci-003") // Modelo GPT
                    .prompt(userInput)        // Entrada del usuario
                    .maxTokens(100)           // Longitud de la respuesta
                    .temperature(0.7)         // Creatividad
                    .build();

            return openAiService.createCompletion(request)
                    .getChoices()
                    .get(0)
                    .getText()
                    .trim();
        } catch (Exception e) {
            return "Error al procesar la solicitud: " + e.getMessage();
        }
    }
}
