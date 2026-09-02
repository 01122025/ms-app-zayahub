package br.com.api.cadastro_barbeiro.adapter.out.mapper;

import br.com.api.cadastro_barbeiro.adapter.out.entity.RegisterProfessionalEntity;
import br.com.api.cadastro_barbeiro.shared.dto.ProfessionalDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegisterProfessionalMapper {

    RegisterProfessionalEntity toRegisterProfessionalEntity(ProfessionalDTO professionalDTO);

    ProfessionalDTO toProfessionalDTO(RegisterProfessionalEntity registerProfessionalEntity);
}
