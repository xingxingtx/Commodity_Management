package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.service.Documentation;
import springfox.documentation.spring.web.DocumentationCache;


@SpringBootApplication
public class CommodityManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(CommodityManagementApplication.class, args);
	}
}