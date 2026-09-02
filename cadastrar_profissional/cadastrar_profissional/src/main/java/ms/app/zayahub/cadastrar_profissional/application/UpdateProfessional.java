package br.com.api.cadastro_barbeiro.application;

import br.com.api.cadastro_barbeiro.application.service.RegisterProfessionalService;
import br.com.api.cadastro_barbeiro.shared.dto.ProfessionalDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class UpdateProfessional {
    private final RegisterProfessionalService registerProfessionalService;

    public ProfessionalDTO updateProfessional(ProfessionalDTO professionalDTO) {
        log.info("update to professional in the database - request received : {}", professionalDTO.nome());
        return registerProfessionalService.updateProfessional(professionalDTO);
    }

}
