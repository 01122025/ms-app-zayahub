package ms.app.zayahub.cadastrar_profissional.application;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ms.app.zayahub.cadastrar_profissional.application.service.RegisterProfessionalService;
import ms.app.zayahub.cadastrar_profissional.application.service.ValidationRuleService;
import ms.app.zayahub.cadastrar_profissional.shared.dto.ProfessionalDTO;

@Slf4j
@RequiredArgsConstructor
public class RegisterProfessional {

    private final RegisterProfessionalService registerProfessionalService;
    private final ValidationRuleService validationRuleService;

    public ProfessionalDTO registerProfessional(ProfessionalDTO professionalDTO) {

        try {
            if (Boolean.TRUE.equals(validationRuleService.checkingRecord(professionalDTO))) {
                log.info("O profissional já está cadastrado no banco de dados.");
            }
            log.info("Registering a professional in the database - request received : {}", professionalDTO);
            return registerProfessionalService.registerProfessional(professionalDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
