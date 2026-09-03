package ms.app.zayahub.cadastrar_profissional.application;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ms.app.zayahub.cadastrar_profissional.application.service.RegisterProfessionalService;
import ms.app.zayahub.cadastrar_profissional.shared.dto.ProfessionalDTO;

@Slf4j
@RequiredArgsConstructor
public class DeleteProfessional {
    private final RegisterProfessionalService registerProfessionalService;

    public ProfessionalDTO deleteProfessional(ProfessionalDTO professionalDTO) {
        log.info("Deleting professional's data from the database - request received: {}", professionalDTO.name());
        return registerProfessionalService.deleteProfessional(professionalDTO);
    }

}
