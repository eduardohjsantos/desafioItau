package dev.java10x.itauJava10x.Config;

import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI apiInfo(){
        return new OpenAPI()
                .info(
                    new Info()
                    .title("Desafio ITAU")
                    .description("Api desafio tecnico ITAU")
                    .version("1.0.0")
                );
    }
}
