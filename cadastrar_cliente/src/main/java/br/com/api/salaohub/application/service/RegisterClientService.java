package br.com.api.salaohub.application.service;

import br.com.api.salaohub.shared.dto.ClientDTO;

import java.util.List;

public interface RegisterClientService {

    List<ClientDTO> findClient();
    ClientDTO registerClient(ClientDTO clientDTO);
    ClientDTO updateClient(ClientDTO clientDTO);
    Long deleteClient(ClientDTO clientDTO);
}
