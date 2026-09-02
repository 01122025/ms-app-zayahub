package ms.app.zayahub.cadastrar_profissional.shared.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.sql.Time;

public record ProfessionalDTO(
        @JsonProperty("id_professional") Long id_professional,
        @JsonProperty("name") @NotNull String nome,
        @JsonProperty("email") @NotNull String email,
        @JsonProperty("phone") String phone,
        @JsonProperty("role") @NotNull String role,
        @JsonProperty("inicio_expediente") @NotNull Time inicioExpediente,
        @JsonProperty("fim_expediente") @NotNull Time fimExpediente,
        @JsonProperty("atend_domicilio") String atendDomicilio,
        @JsonProperty("specialization") @NotNull String specialization) {
}
