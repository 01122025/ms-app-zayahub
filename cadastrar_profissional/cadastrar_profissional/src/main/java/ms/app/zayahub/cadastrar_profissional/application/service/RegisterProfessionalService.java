package ms.app.zayahub.cadastrar_profissional.application.service;


import ms.app.zayahub.cadastrar_profissional.shared.dto.ProfessionalDTO;

import java.util.List;

public interface RegisterProfessionalService {
    ProfessionalDTO registerProfessional(ProfessionalDTO professionalDTO);
    ProfessionalDTO updateProfessional(ProfessionalDTO professionalDTO);
    ProfessionalDTO deleteProfessional(ProfessionalDTO professionalDTO);
    List<ProfessionalDTO> listAllProfessional();
}
