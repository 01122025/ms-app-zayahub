package ms.app.zayahub.cadastrar_profissional.boot.config;


import ms.app.zayahub.cadastrar_profissional.application.DeleteProfessional;
import ms.app.zayahub.cadastrar_profissional.application.RegisterProfessional;
import ms.app.zayahub.cadastrar_profissional.application.UpdateProfessional;
import ms.app.zayahub.cadastrar_profissional.application.service.RegisterProfessionalService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegisterProfessionalConfig {
    @Bean
    public RegisterProfessional registerProfessional(RegisterProfessionalService registerProfessional) {
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
