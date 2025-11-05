package com.smartrabbit.movie_play.domain.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface MoviePlayAIService {
    @UserMessage("""
            Genera un saludo de bienvenida a la plataforma de GestiÃ³n de PelÃ­culas {{platform}}. 
            Usa menos de 120 caracteres y hazlo con el estilo de Platzi.
            """)
    String generateGreeting(@V("platform") String platform);

    @SystemMessage("""
            Eres un experto en cine que recomienda pelÃ­culas personalizadas segÃºn los gustos del usuario.
            Debes recomendar mÃ¡ximo 3 pelÃ­culas.
            No incluyas pelÃ­culas que estÃ©n por fuera de la plataforma PlatziPlay.
            """)
    String generateMovieSuggestion(@UserMessage String userMessage);
}
