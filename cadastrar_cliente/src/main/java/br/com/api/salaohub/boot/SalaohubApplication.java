package br.com.api.salaohub.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"br.com.api.salaohub"})
@EntityScan(basePackages = {"br.com.api.salaohub.adapter.out.entity"})
@EnableJpaRepositories(basePackages = {"br.com.api.salaohub.adapter.out.jpaRepository"})
@EnableJpaAuditing
@SpringBootApplication
public class SalaohubApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalaohubApplication.class, args);
	}

}
