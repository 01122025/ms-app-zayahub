package ms.app.zayahub.cadastrar_profissional.application.service;

import ms.app.zayahub.cadastrar_profissional.shared.dto.ProfessionalDTO;

public interface ValidationRuleService {
    Boolean checkingRecord(ProfessionalDTO professionalDTO);
    Boolean checkingId(ProfessionalDTO professionalDTO);
    Boolean checkingActiveUsers();

}
