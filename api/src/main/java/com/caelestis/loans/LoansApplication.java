package com.caelestis.loans;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Loans microservice REST API Documentantion",
				description = "Loans microservice bank integrated with many others microservice",
				version = "v1",
				contact = @Contact(
						name = "Jefferson Celestino",
						email = "contato@jeffersoncelestino.dev.br",
						url = "https://www.linkedin.com/in/caelestis/"
				),
				license = @License(
						name = "Licence: apache 2.0",
						url = "https://www.linkedin.com/in/caelestis/"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Loans microservice REST API External Documentation",
				url = "https://www.linkedin.com/in/caelestis/"
		)
)
public class LoansApplication {
	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}
}
