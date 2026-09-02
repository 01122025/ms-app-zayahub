package br.com.api.cadastro_barbeiro.application.service;

import br.com.api.cadastro_barbeiro.shared.dto.ProfessionalDTO;

public interface RegisterProfessionalService {
    ProfessionalDTO registerProfessional(ProfessionalDTO professionalDTO);
    ProfessionalDTO updateProfessional(ProfessionalDTO professionalDTO);
    ProfessionalDTO deleteProfessional(ProfessionalDTO professionalDTO);
}
