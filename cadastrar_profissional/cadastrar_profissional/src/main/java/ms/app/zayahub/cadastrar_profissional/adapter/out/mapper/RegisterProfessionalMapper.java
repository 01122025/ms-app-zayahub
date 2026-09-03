package ms.app.zayahub.cadastrar_profissional.adapter.out.mapper;


import ms.app.zayahub.cadastrar_profissional.adapter.out.entity.RegisterProfessionalEntity;
import ms.app.zayahub.cadastrar_profissional.shared.dto.ProfessionalDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RegisterProfessionalMapper {

    RegisterProfessionalEntity toRegisterProfessionalEntity(ProfessionalDTO professionalDTO);

    ProfessionalDTO toProfessionalDTO(RegisterProfessionalEntity registerProfessionalEntity);

    List<ProfessionalDTO> toProfessionalDTOList(List<RegisterProfessionalEntity> registerProfessionalEntities);

}
