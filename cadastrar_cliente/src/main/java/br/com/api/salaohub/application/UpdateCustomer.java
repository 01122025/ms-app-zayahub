package br.com.api.salaohub.application;

import br.com.api.salaohub.application.service.RegisterClientService;
import br.com.api.salaohub.application.service.ValidatingRuleService;
import br.com.api.salaohub.shared.dto.ClientDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class UpdateCustomer {

    private final RegisterClientService registerClientService;
    private final ValidatingRuleService validatingRuleService;

    public ClientDTO updateClient(ClientDTO clientDTO) {

        try {
            if (validatingRuleService.checkingId(clientDTO)) {
                log.info("Client found with ID: {}", clientDTO.idClient());
            }
            log.info("Updating client's data in the database - request received: {}", clientDTO.name());
            return registerClientService.updateClient(clientDTO);
        } catch (Exception e) {
            log.error("Error updating client: {}", e.getMessage());
            throw e;
        }

    }
}
