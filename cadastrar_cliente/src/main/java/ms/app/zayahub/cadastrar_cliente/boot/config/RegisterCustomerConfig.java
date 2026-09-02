package ms.app.zayahub.cadastrar_cliente.boot.config;


import ms.app.zayahub.cadastrar_cliente.application.DeleteCustomer;
import ms.app.zayahub.cadastrar_cliente.application.RegisterCustomer;
import ms.app.zayahub.cadastrar_cliente.application.UpdateCustomer;
import ms.app.zayahub.cadastrar_cliente.application.service.RegisterClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegisterCustomerConfig {

    @Bean
    public RegisterCustomer registerCustomer(RegisterClientService registerClientService) {
        return new RegisterCustomer(registerClientService);
    }

    @Bean
    public UpdateCustomer updateCustomer(RegisterClientService registerClientService) {
        return new UpdateCustomer(registerClientService);
    }

    @Bean
    public DeleteCustomer deleteCustomer(RegisterClientService registerClientService) {
        return new DeleteCustomer(registerClientService);
    }
}
