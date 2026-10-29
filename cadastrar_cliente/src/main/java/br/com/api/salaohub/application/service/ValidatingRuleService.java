package br.com.api.salaohub.application.service;

import br.com.api.salaohub.shared.dto.ClientDTO;

public interface ValidatingRuleService {
    Boolean validateClientActive(ClientDTO clientDTO);
    Boolean checkingId(ClientDTO clientDTO);
    Boolean validateClient();
}
