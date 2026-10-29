package br.com.api.salaohub.application;

import br.com.api.salaohub.application.service.RegisterClientService;
import br.com.api.salaohub.application.service.ValidatingRuleService;
import br.com.api.salaohub.shared.dto.ClientDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class DeleteCustomer {

    private final RegisterClientService registerClientService;
    private final ValidatingRuleService validatingRuleService;

    public Long deleteClient(ClientDTO clientDTO) {
        try {
            if (validatingRuleService.checkingId(clientDTO)) {
                log.info("Client found with ID: {}", clientDTO.idClient());
            }
            log.info("Deleting client's data from the database - request received: {}", clientDTO.name());
            return registerClientService.deleteClient(clientDTO);
        } catch (Exception e) {
            log.error("Error deleting client: {}", e.getMessage());
            throw e;
        }
    }
}
