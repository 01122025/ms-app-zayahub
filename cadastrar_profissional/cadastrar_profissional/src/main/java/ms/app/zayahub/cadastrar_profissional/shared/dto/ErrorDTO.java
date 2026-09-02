package br.com.api.cadastro_barbeiro.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public record ErrorDTO(
       @JsonProperty("code") String code,
        @JsonProperty("message") String message,
        @JsonProperty("reason") String reason,
        @JsonProperty("status_code") int statusCode
) {}
