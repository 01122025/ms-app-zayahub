package br.com.api.salaohub.application;

import br.com.api.salaohub.application.service.RegisterClientService;
import br.com.api.salaohub.application.service.ValidatingRuleService;
import br.com.api.salaohub.shared.dto.ClientDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class ListClient {

    private final RegisterClientService registerClientService;
    private final ValidatingRuleService validatingRuleService;

    public List<ClientDTO> findByActiveTrue() {
        try {
            if (Boolean.TRUE.equals(validatingRuleService.validateClient())) {
                log.info("active client in the system, returning the list of clients!!");
            }
            return registerClientService.findClient();
        } catch (Exception e) {
            log.error("Error finding active clients: {}", e.getMessage());
            throw e;

        }
    }
}
