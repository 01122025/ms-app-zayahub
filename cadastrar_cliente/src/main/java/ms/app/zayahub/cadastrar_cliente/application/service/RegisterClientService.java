package ms.app.zayahub.cadastrar_cliente.application.service;


import ms.app.zayahub.cadastrar_cliente.shared.dto.ClientDTO;

public interface RegisterClientService {

    ClientDTO registerClient(ClientDTO clientDTO);
    ClientDTO updateClient(ClientDTO clientDTO);
    Long deleteClient(ClientDTO clientDTO);
}
