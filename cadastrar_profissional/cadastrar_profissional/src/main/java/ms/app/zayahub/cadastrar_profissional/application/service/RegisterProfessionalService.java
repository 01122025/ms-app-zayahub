package ms.app.zayahub.cadastrar_profissional.application.service;


import ms.app.zayahub.cadastrar_profissional.shared.dto.ProfessionalDTO;

public interface RegisterProfessionalService {
    ProfessionalDTO registerProfessional(ProfessionalDTO professionalDTO);
    ProfessionalDTO updateProfessional(ProfessionalDTO professionalDTO);
    Long deleteProfessional(Long id);
}
