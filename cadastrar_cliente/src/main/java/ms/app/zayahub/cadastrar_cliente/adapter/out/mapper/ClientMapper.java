package ms.app.zayahub.cadastrar_cliente.adapter.out.mapper;


import ms.app.zayahub.cadastrar_cliente.adapter.out.entity.ClientEntity;
import ms.app.zayahub.cadastrar_cliente.shared.dto.ClientDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

     ClientEntity DTOtoEntity(ClientDTO clientDTO);

     ClientDTO entityToDTO(ClientEntity clientEntity);
}
