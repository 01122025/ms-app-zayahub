package ms.app.zayahub.cadastrar_profissional.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ms.app.zayahub.cadastrar_profissional.application.service.RegisterProfessionalService;
import ms.app.zayahub.cadastrar_profissional.application.service.ValidationRuleService;
import ms.app.zayahub.cadastrar_profissional.shared.dto.ProfessionalDTO;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class GetListProfessional {

    private final RegisterProfessionalService registerProfessionalService;
    private final ValidationRuleService validationRuleService;

    public List<ProfessionalDTO> listProfessionals() {

        try {
            if(validationRuleService.checkingActiveUsers() == true) {
                log.info("Active users found.");
            }
            return registerProfessionalService.listAllProfessional();
        } catch (Exception e) {
            log.error("Error listing professionals: {}", e.getMessage());
            throw e; // Rethrow the exception after logging it
        }
    }
}
