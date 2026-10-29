package br.com.api.salaohub.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public record AddressDTO(

        @JsonProperty("id") Long id,
        @JsonProperty("street") String street,
        @JsonProperty("neighborhood") String neighborhood,
        @JsonProperty("zipCode") String zipCode,
        @JsonProperty("city") String city,
        @JsonProperty("state") String state,
        @JsonProperty("number") String number,
        @JsonProperty("complement") String complement
) {
}
