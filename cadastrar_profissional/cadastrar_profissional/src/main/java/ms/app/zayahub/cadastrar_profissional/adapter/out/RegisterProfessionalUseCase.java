package ms.app.zayahub.cadastrar_profissional.adapter.out;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ms.app.zayahub.cadastrar_profissional.adapter.out.mapper.RegisterProfessionalMapper;
import ms.app.zayahub.cadastrar_profissional.adapter.out.repository.RegisterProfessionalRepository;
import ms.app.zayahub.cadastrar_profissional.application.service.RegisterProfessionalService;
import ms.app.zayahub.cadastrar_profissional.shared.dto.ProfessionalDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class RegisterProfessionalUseCase implements RegisterProfessionalService {

    private final RegisterProfessionalMapper mapperRegisterProfessional;
    private final RegisterProfessionalRepository jparegisterProfessional;

    @Override
    public List<ProfessionalDTO> listAllProfessional() {
        try {
            var serchUsers = jparegisterProfessional.findByActiveTrue();

            if (serchUsers.isEmpty()) {
                log.warn("No active professionals found in the database.");
                return List.of();
            }

            log.info("Active professionals found in the database.");
            return mapperRegisterProfessional.toProfessionalDTOList(serchUsers);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ProfessionalDTO registerProfessional(ProfessionalDTO professionalDTO) {
       log.info("inicializando o registro do profissional no banco de dados - request received : {}", professionalDTO);
        try {
            var persistence = mapperRegisterProfessional.toRegisterProfessionalEntity(professionalDTO);
            persistence.setId_professional(null); // garante que é sempre INSERT, nunca UPDATE
            var result = jparegisterProfessional.save(persistence);
            return mapperRegisterProfessional.toProfessionalDTO(result);
        } catch (Exception ex) {
            throw new RuntimeException("Error registering professional: " + ex.getMessage(), ex);
        }
    }

    @Override
    public ProfessionalDTO updateProfessional(ProfessionalDTO professionalDTO) {

        try {

            log.info("update in the database - request received : {}", professionalDTO);
            var persistence = mapperRegisterProfessional.toRegisterProfessionalEntity(professionalDTO);
            log.info("update in the database - response : {}", persistence);
            var result = jparegisterProfessional.save(persistence);
            return mapperRegisterProfessional.toProfessionalDTO(result);

        } catch (Exception e) {
            log.error("Error updating professional in the database: {}", e.getMessage());
            throw e; // rethrow the exception after logging
        }
    }

    @Override
    public ProfessionalDTO deleteProfessional(ProfessionalDTO professionalDTO) {

        try {
            if (!jparegisterProfessional.existsById(professionalDTO.id_professional())) {
                log.warn("Professional with ID {} does not exist. Cannot delete.", professionalDTO.id_professional());
                throw new IllegalArgumentException("Professional with ID " + professionalDTO.id_professional() + " does not exist.");
            }
            log.info("delete in the database - request received : {}", professionalDTO);
            var deleteDataBase = jparegisterProfessional.getReferenceById(professionalDTO.id_professional());
            var result = mapperRegisterProfessional.toProfessionalDTO(deleteDataBase);
            log.info("delete in the database - response : {}", result);
            jparegisterProfessional.delete(deleteDataBase);
            return result;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


}
