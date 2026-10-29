package br.com.api.salaohub.application;

import br.com.api.salaohub.application.service.RegisterClientService;
import br.com.api.salaohub.application.service.ValidatingRuleService;
import br.com.api.salaohub.shared.dto.ClientDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class RegisterCustomer {

    private final RegisterClientService registerClientService;
    private final ValidatingRuleService validatingRuleService;

    public ClientDTO registerCustomer(ClientDTO clientDTO) {
        try {
            if (Boolean.TRUE.equals(validatingRuleService.validateClientActive(clientDTO))) {
                log.info("Client is already active: {}", clientDTO.idClient());
            }
            return registerClientService.registerClient(clientDTO);
        } catch (Exception e) {
            log.error("Error registering client: {}", e.getMessage());
            throw e;
        }
    }
}
