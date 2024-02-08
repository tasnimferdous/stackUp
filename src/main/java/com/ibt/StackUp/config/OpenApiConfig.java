package com.ibt.StackUp.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "StackUp Application",
                description = "The application is built to keep trace of the assigned tasks.",
                contact = @Contact(
                        name = "IB Team",
                        email = "ib@mislbd.com "
                ),
                version = "0.0"
        ),
        servers = {
                @Server(
                        description = "Dev",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "Test",
                        url = "http://localhost:8080"
                )
        }
)
public class OpenApiConfig {
}
