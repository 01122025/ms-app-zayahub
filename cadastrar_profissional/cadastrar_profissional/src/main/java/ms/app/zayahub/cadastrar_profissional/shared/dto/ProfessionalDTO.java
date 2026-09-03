package ms.app.zayahub.cadastrar_profissional.shared.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.sql.Time;

public record ProfessionalDTO(
        @JsonProperty("id_professional") Long id_professional,
        @JsonProperty("name") @NotNull String name,
        @JsonProperty("email") @NotNull String email,
        @JsonProperty("phone") String phone,
        @JsonProperty("role") @NotNull String role,
        @JsonProperty("inicio_expediente") @NotNull Time startBusinessHours,
        @JsonProperty("fim_expediente") @NotNull Time endWorkday,
        @JsonProperty("atend_domicilio") String homeService,
        @JsonProperty("active") Boolean active,
        @JsonProperty("specialization") @NotNull String specialization) {
}
