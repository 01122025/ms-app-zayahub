package ms.app.zayahub.cadastrar_cliente.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public record AddressDTO(

        @JsonProperty("id") String id,
        @JsonProperty("street") String street,
        @JsonProperty("neighborhood") String neighborhood,
        @JsonProperty("zipCode") String zipCode,
        @JsonProperty("city") String city,
        @JsonProperty("state") String state,
        @JsonProperty("number") String number,
        @JsonProperty("complement") String complemento
) {
}
