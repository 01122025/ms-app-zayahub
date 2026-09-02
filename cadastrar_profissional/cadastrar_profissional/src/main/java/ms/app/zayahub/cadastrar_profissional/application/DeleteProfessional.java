package ms.app.zayahub.cadastrar_profissional.application;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ms.app.zayahub.cadastrar_profissional.application.service.RegisterProfessionalService;
import ms.app.zayahub.cadastrar_profissional.shared.dto.ProfessionalDTO;

@Slf4j
@RequiredArgsConstructor
public class DeleteProfessional {
    private final RegisterProfessionalService registerProfessionalService;

    public Long deleteProfessional(Long id) {
        log.info("Deleting professional's data from the database - request received: {}", id);
        return registerProfessionalService.deleteProfessional(id);
    }

}
