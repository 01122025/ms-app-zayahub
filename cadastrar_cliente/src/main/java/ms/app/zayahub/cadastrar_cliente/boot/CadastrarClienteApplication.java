package ms.app.zayahub.cadastrar_cliente.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"ms/app/zayahub/cadastrar_cliente"})
@EntityScan(basePackages = {"ms/app/zayahub/cadastrar_cliente/adapter/out/entity"})
@EnableJpaRepositories(basePackages = {"ms/app/zayahub/cadastrar_cliente/adapter/out/jpaRepository"})
@EnableJpaAuditing
@SpringBootApplication
public class CadastrarClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastrarClienteApplication.class, args);
	}

}
