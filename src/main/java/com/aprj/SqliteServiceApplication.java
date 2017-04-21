package com.aprj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;

@SpringBootApplication
public class SqliteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqliteServiceApplication.class, args);
	}
}
