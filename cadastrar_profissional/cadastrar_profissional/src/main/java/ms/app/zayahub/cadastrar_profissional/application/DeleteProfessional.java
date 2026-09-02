package br.com.api.cadastro_barbeiro.application;

import br.com.api.cadastro_barbeiro.application.service.RegisterProfessionalService;
import br.com.api.cadastro_barbeiro.shared.dto.ProfessionalDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class DeleteProfessional {
    private final RegisterProfessionalService registerProfessionalService;

    public ProfessionalDTO deleteProfessional(ProfessionalDTO professionalDTO) {
        log.info("Deleting professional's data from the database - request received: {}", professionalDTO.nome());
        return registerProfessionalService.deleteProfessional(professionalDTO);
    }

}
