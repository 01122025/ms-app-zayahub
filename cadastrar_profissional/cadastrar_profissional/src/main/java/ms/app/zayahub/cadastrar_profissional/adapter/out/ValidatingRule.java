package ms.app.zayahub.cadastrar_profissional.adapter.out;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ms.app.zayahub.cadastrar_profissional.adapter.out.repository.ValidatingRuleRepository;
import ms.app.zayahub.cadastrar_profissional.application.service.ValidationRuleService;
import ms.app.zayahub.cadastrar_profissional.shared.dto.ProfessionalDTO;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ValidatingRule implements ValidationRuleService {

    private final ValidatingRuleRepository validatingRuleRepository;

    @Override
    public Boolean checkingRecord(ProfessionalDTO professionalDTO) {
        Boolean result = false;
        try {
            if (validatingRuleRepository.existsByEmail(professionalDTO.email()) || validatingRuleRepository.existsByName(professionalDTO.name())) {
                log.info("ProfessionalDTO.email exists and ProfessionalDTO.name");
                result = true;
            }
            if (professionalDTO.id_professional() != null && !validatingRuleRepository.existsById(professionalDTO.id_professional())) {
                log.warn("Professional with ID {} already exists. Cannot register.", professionalDTO.id_professional());
                throw new IllegalArgumentException("Professional with ID " + professionalDTO.id_professional() + " already exists.");
            }
        } catch (Exception e) {
            log.error("Error checking record: {}", e.getMessage());
        }
        return result;
    }

    @Override
    public Boolean checkingId(ProfessionalDTO professionalDTO) {
        Boolean result = false;
        try {
            if (validatingRuleRepository.existsById(professionalDTO.id_professional())) {
                log.info("Professional with ID {} exists. Proceeding with update.", professionalDTO.id_professional());
            } else {
                log.warn("Professional with ID {} does not exist. Cannot update.", professionalDTO.id_professional());
                throw new IllegalArgumentException("Professional with ID " + professionalDTO.id_professional() + " does not exist.");
            }
        } catch (Exception e) {
            log.error("Error checking ID: {}", e.getMessage());
        }
        return result;
    }

    @Override
    public Boolean checkingActiveUsers() {
        Boolean result = false;
        try {
            if (validatingRuleRepository.existsActiveUsers()) {
                log.info("There are active users in the database");
                result = true;
            }
        } catch (Exception e) {
            log.error("Error checking active users: {}", e.getMessage());
        }
        return result;
    }
}
