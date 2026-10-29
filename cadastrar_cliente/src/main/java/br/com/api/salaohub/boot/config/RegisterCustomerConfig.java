package br.com.api.salaohub.boot.config;

import br.com.api.salaohub.application.DeleteCustomer;
import br.com.api.salaohub.application.ListClient;
import br.com.api.salaohub.application.UpdateCustomer;
import br.com.api.salaohub.application.service.RegisterClientService;
import br.com.api.salaohub.application.RegisterCustomer;
import br.com.api.salaohub.application.service.ValidatingRuleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegisterCustomerConfig {

    @Bean
    public ListClient findByActiveTrue(RegisterClientService registerClientService, ValidatingRuleService validatingRuleService) {
        return new ListClient(registerClientService, validatingRuleService);
    }

    @Bean
    public RegisterCustomer  registerCustomer(RegisterClientService registerClientService, ValidatingRuleService validatingRuleService) {
        return new RegisterCustomer(registerClientService, validatingRuleService);
    }

     @Bean
    public UpdateCustomer updateCustomer(RegisterClientService registerClientService, ValidatingRuleService validatingRuleService) {
        return new UpdateCustomer(registerClientService, validatingRuleService);
    }

    @Bean
    public DeleteCustomer deleteCustomer(RegisterClientService registerClientService, ValidatingRuleService validatingRuleService) {
        return new DeleteCustomer(registerClientService, validatingRuleService);
    }
}
