package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        Server server = new Server()
                .url("https://9257.408procr.amypo.ai/")
                .description("Remote HTTPS Server");

        return new OpenAPI()
                .servers(List.of(server));
    }
}

