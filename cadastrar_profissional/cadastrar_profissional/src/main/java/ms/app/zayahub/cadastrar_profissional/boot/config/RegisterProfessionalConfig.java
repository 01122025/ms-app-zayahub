package br.com.api.cadastro_barbeiro.boot.config;

import br.com.api.cadastro_barbeiro.application.DeleteProfessional;
import br.com.api.cadastro_barbeiro.application.RegisterProfessional;
import br.com.api.cadastro_barbeiro.application.UpdateProfessional;
import br.com.api.cadastro_barbeiro.application.service.RegisterProfessionalService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegisterProfessionalConfig {
    @Bean
    public RegisterProfessional  registerProfessional(RegisterProfessionalService registerProfessional) {
        return new RegisterProfessional(registerProfessional);
    }
    @Bean
    public UpdateProfessional updateProfessional(RegisterProfessionalService registerProfessionalService) {
        return new UpdateProfessional(registerProfessionalService);
    }

    @Bean
    public DeleteProfessional deleteProfessional(RegisterProfessionalService registerProfessionalServiceDelete) {
        return new DeleteProfessional(registerProfessionalServiceDelete);
    }
}
