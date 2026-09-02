package br.com.api.cadastro_barbeiro.adapter.out;

import br.com.api.cadastro_barbeiro.adapter.out.mapper.RegisterProfessionalMapper;
import br.com.api.cadastro_barbeiro.adapter.out.repository.RegisterProfessionalRepository;
import br.com.api.cadastro_barbeiro.application.service.RegisterProfessionalService;
import br.com.api.cadastro_barbeiro.shared.dto.ProfessionalDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
        persistence.setId(null); // garante que é sempre INSERT, nunca UPDATE
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
    public ProfessionalDTO deleteProfessional(ProfessionalDTO professionalDTO) {
        log.info("delete in the database - request received : {}", professionalDTO);
        var deleteDataBase= jparegisterProfessional.getReferenceById(professionalDTO.id());
        var result = mapperRegisterProfessional.toProfessionalDTO(deleteDataBase);
        log.info("delete in the database - response : {}", result);
        jparegisterProfessional.delete(deleteDataBase);
        return result;
    }
}
