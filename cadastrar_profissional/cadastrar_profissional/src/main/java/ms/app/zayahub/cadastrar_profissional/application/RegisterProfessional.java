package br.com.api.cadastro_barbeiro.application;

import br.com.api.cadastro_barbeiro.application.service.RegisterProfessionalService;
import br.com.api.cadastro_barbeiro.shared.dto.ProfessionalDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class RegisterProfessional {

    private final RegisterProfessionalService registerProfessionalService;

    public ProfessionalDTO registerProfessional(ProfessionalDTO professionalDTO) {
        log.info("Registering a professional in the database - request received : {}", professionalDTO);
        return registerProfessionalService.registerProfessional(professionalDTO);
    }
}
