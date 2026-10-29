package br.com.api.salaohub.adapter.out;

import br.com.api.salaohub.adapter.out.jpaRepository.ValidatingRuleRepository;
import br.com.api.salaohub.application.service.ValidatingRuleService;
import br.com.api.salaohub.shared.dto.ClientDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class ValidatingRule implements ValidatingRuleService {

    private final ValidatingRuleRepository jpaRepository;


    @Override
    public Boolean validateClientActive(ClientDTO clientDTO) {
        Boolean clientId = false;
        try {
            if (jpaRepository.existsActiveClient() && clientDTO.idClient() != null) {
                log.info("ValidatingRule validateClientActive");
                clientId = true;
            }
        } catch (Exception e) {
            log.error("Error occurred while validating client active status", e);
        }
        return clientId;
    }

    @Override
    public Boolean checkingId(ClientDTO clientDTO) {
        Boolean checkingId = false;
        try {
            if (jpaRepository.existsById(clientDTO.idClient())) {
                log.info("Client with ID {} exists in the database", clientDTO.idClient());
                checkingId = true;
            }
        } catch (Exception e) {
            log.error("Error occurred while validating client active status", e);
        }
        return checkingId;
    }

    @Override
    public Boolean validateClient() {
        Boolean result = false;
        try {
            if (jpaRepository.existsActiveClient()) {
                log.info("There are active users in the database");
                result = true;
            }
        } catch (Exception e) {
            log.error("Error checking active users: {}", e.getMessage());
        }
        return result;
    }
}
