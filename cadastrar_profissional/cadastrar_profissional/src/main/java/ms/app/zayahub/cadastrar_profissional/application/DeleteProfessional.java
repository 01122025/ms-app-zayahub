package ms.app.zayahub.cadastrar_profissional.application;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ms.app.zayahub.cadastrar_profissional.application.service.RegisterProfessionalService;
import ms.app.zayahub.cadastrar_profissional.application.service.ValidationRuleService;
import ms.app.zayahub.cadastrar_profissional.shared.dto.ProfessionalDTO;

@Slf4j
@RequiredArgsConstructor
public class DeleteProfessional {

    private final RegisterProfessionalService registerProfessionalService;
    private final ValidationRuleService validationRuleService;

    public ProfessionalDTO deleteProfessional(ProfessionalDTO professionalDTO) {
        try {
            if (validationRuleService.checkingId(professionalDTO)){
                log.info("Professional ID exists. Proceeding with update.");
            }

        } catch (Exception e) {
            log.error("Error deleting professional: {}", e.getMessage());
            throw e; // Rethrow the exception after logging it
        }

        log.info("Deleting professional's data from the database - request received: {}", professionalDTO.name());
        return registerProfessionalService.deleteProfessional(professionalDTO);
    }

}
