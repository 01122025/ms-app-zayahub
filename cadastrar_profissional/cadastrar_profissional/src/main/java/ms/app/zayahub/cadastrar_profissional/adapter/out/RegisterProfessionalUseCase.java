package ms.app.zayahub.cadastrar_profissional.adapter.out;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ms.app.zayahub.cadastrar_profissional.adapter.out.mapper.RegisterProfessionalMapper;
import ms.app.zayahub.cadastrar_profissional.adapter.out.repository.RegisterProfessionalRepository;
import ms.app.zayahub.cadastrar_profissional.application.service.RegisterProfessionalService;
import ms.app.zayahub.cadastrar_profissional.shared.dto.ProfessionalDTO;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class RegisterProfessionalUseCase implements RegisterProfessionalService {

    private final RegisterProfessionalMapper mapperRegisterProfessional;
    private final RegisterProfessionalRepository jparegisterProfessional;


    @Override
    public ProfessionalDTO registerProfessional(ProfessionalDTO professionalDTO) {
        if (jparegisterProfessional.existsByNome(professionalDTO.nome())) {
            throw new IllegalArgumentException("Já existe um profissional com esse nome");
        }
        var persistence = mapperRegisterProfessional.toRegisterProfessionalEntity(professionalDTO);
        persistence.setId_professional(null); // garante que é sempre INSERT, nunca UPDATE
        var result = jparegisterProfessional.save(persistence);
        return mapperRegisterProfessional.toProfessionalDTO(result);
    }

    @Override
    public ProfessionalDTO updateProfessional(ProfessionalDTO professionalDTO) {
        log.info("update in the database - request received : {}", professionalDTO);
        var persistence = mapperRegisterProfessional.toRegisterProfessionalEntity(professionalDTO);
       log.info("update in the database - response : {}", persistence);
        var result= jparegisterProfessional.save(persistence);
        return mapperRegisterProfessional.toProfessionalDTO(result) ;
    }

    @Override
    public Long deleteProfessional(Long id) {
        log.info("delete in the database - request received : {}", id);
        var deleteDataBase= jparegisterProfessional.getReferenceById(id);
        jparegisterProfessional.delete(deleteDataBase);
        var result = mapperRegisterProfessional.toProfessionalDTO(deleteDataBase);
        log.info("delete in the database - response : {}", result);
        return result.id_professional();
    }

}
