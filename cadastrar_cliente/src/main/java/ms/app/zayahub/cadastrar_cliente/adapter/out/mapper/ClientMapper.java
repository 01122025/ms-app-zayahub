package ms.app.zayahub.cadastrar_cliente.adapter.out.mapper;


import ms.app.zayahub.cadastrar_cliente.adapter.out.entity.AddressEntity;
import ms.app.zayahub.cadastrar_cliente.adapter.out.entity.ClientEntity;
import ms.app.zayahub.cadastrar_cliente.shared.dto.AddressDTO;
import ms.app.zayahub.cadastrar_cliente.shared.dto.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {

     @Mapping(source = "addressDTO", target = "address")
     ClientEntity DTOtoEntity(ClientDTO clientDTO);

     @Mapping(source = "address", target = "addressDTO")
     ClientDTO entityToDTO(ClientEntity clientEntity);

     // helper mappings for nested Address
     AddressEntity addressDTOToAddressEntity(AddressDTO dto);

     AddressDTO addressEntityToAddressDTO(AddressEntity entity);
}
