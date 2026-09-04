package ms.app.zayahub.cadastrar_profissional.boot.config;


import ms.app.zayahub.cadastrar_profissional.application.DeleteProfessional;
import ms.app.zayahub.cadastrar_profissional.application.GetListProfessional;
import ms.app.zayahub.cadastrar_profissional.application.RegisterProfessional;
import ms.app.zayahub.cadastrar_profissional.application.UpdateProfessional;
import ms.app.zayahub.cadastrar_profissional.application.service.RegisterProfessionalService;
import ms.app.zayahub.cadastrar_profissional.application.service.ValidationRuleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegisterProfessionalConfig {

    @Bean
    public GetListProfessional getListProfessional(RegisterProfessionalService registerProfessionalService, ValidationRuleService validationRuleService) {
        return new GetListProfessional(registerProfessionalService, validationRuleService);
    }

    @Bean
    public RegisterProfessional registerProfessional(RegisterProfessionalService registerProfessionalService, ValidationRuleService validationRuleService) {
        return new RegisterProfessional(registerProfessionalService, validationRuleService);
    }
    @Bean
    public UpdateProfessional updateProfessional(RegisterProfessionalService registerProfessionalService, ValidationRuleService validationRuleService) {
        return new UpdateProfessional(registerProfessionalService, validationRuleService);
    }

    @Bean
    public DeleteProfessional deleteProfessional(RegisterProfessionalService registerProfessionalService, ValidationRuleService validationRuleService) {
        return new DeleteProfessional(registerProfessionalService, validationRuleService);
    }

}
