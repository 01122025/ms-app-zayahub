package ms.app.zayahub.cadastrar_cliente.adapter.out;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ms.app.zayahub.cadastrar_cliente.adapter.out.entity.ClientEntity;
import ms.app.zayahub.cadastrar_cliente.adapter.out.jpaRepository.RegisterClientJpaRepository;
import ms.app.zayahub.cadastrar_cliente.adapter.out.mapper.ClientMapper;
import ms.app.zayahub.cadastrar_cliente.application.service.RegisterClientService;
import ms.app.zayahub.cadastrar_cliente.shared.dto.ClientDTO;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class RegisterCustomerUseCase implements RegisterClientService {
    private final ClientMapper clientMapper;
    private final RegisterClientJpaRepository registerClientJpaRepository;

    @Override
    public ClientDTO registerClient(ClientDTO clientDTO) {
        log.info("Register client from database ID: {}, name:{}", clientDTO.idClient(), clientDTO.name());
        ClientEntity clientEntity = clientMapper.DTOtoEntity(clientDTO);
        log.info("Register client {}", clientEntity);
        registerClientJpaRepository.save(clientEntity);
        return clientMapper.entityToDTO(clientEntity);
    }

    @Override
    public ClientDTO updateClient(ClientDTO clientDTO) {
        log.info("Update client from database ID: {}", clientDTO.idClient());
        var searchId = registerClientJpaRepository.getReferenceById(clientDTO.idClient());
        log.info("Update client {}", searchId);
        var mapperReturn = clientMapper.DTOtoEntity(clientDTO);
        registerClientJpaRepository.save(mapperReturn);
        return clientMapper.entityToDTO(mapperReturn);
    }

    @Override
    public ClientDTO deleteClient(ClientDTO clientDTO) {
        log.info("Delete client from database ID: {}", clientDTO.idClient());
        var deleteClient = registerClientJpaRepository.getReferenceById(clientDTO.idClient());
        registerClientJpaRepository.delete(deleteClient);
        log.info("Delete client {}", deleteClient.getIdClient());
        return clientMapper.entityToDTO(deleteClient);
    }
}