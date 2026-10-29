package br.com.api.salaohub.adapter.out.mapper;

import br.com.api.salaohub.adapter.out.entity.AddressEntity;
import br.com.api.salaohub.adapter.out.entity.ClientEntity;
import br.com.api.salaohub.shared.dto.AddressDTO;
import br.com.api.salaohub.shared.dto.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(source = "addressDTO", target = "address")
    ClientEntity DTOtoEntity(ClientDTO clientDTO);

   @Mapping(source = "address", target = "addressDTO")
    ClientDTO entityToDTO(ClientEntity clientEntity);

   List<ClientDTO> DTOtoClient(List<ClientEntity> clientEntityList);

   List<ClientEntity> entityToDTO(List<ClientDTO> clientDtosList);

   // helper mappings for nested Address
    AddressEntity addressDTOToAddressEntity(AddressDTO dto);

    AddressDTO addressEntityToAddressDTO(AddressEntity entity);
}
