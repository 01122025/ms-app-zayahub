package ms.app.zayahub.cadastrar_cliente.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import ms.app.zayahub.cadastrar_cliente.shared.enums.Accessibility;

public record ClientDTO(
        @JsonProperty("idClient") Long idClient,
        @JsonProperty("name") @NotNull String name,
        @JsonProperty("email") @NotNull String email,
        @JsonProperty("phone") @NotNull String phone,
        @JsonProperty("role") @NotNull String role,
        @JsonProperty("addressDTO") @NotNull AddressDTO addressDTO,
        @JsonProperty("accessibility") @NotNull Accessibility accessibility
) {
}
