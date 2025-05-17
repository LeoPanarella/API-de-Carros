package api;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Carros")
                        .description("Documentação da API de Carros")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Leonardo Panarella")
                                .url("https://github.com/LeoPanarella"))
                        .license(new License()
                                .name("Apache License Version 2.0")
                                .url("https://apache.org")));
    }
}

