package br.com.api.salaohub.shared.dto;

import br.com.api.salaohub.shared.enums.Accessibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;

public record ClientDTO(
        @JsonProperty("idClient") Long idClient,
        @JsonProperty("name") @NotNull String name,
        @JsonProperty("email") @NotNull String email,
        @JsonProperty("phone") @NotNull String phone,
        @JsonProperty("role") @NotNull String role,
        @JsonProperty("addressDTO") @NotNull AddressDTO addressDTO,
        @JsonProperty("active") Boolean active,
        @JsonProperty("accessibility") @NotNull Accessibility accessibility
) {
}
