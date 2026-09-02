package br.com.api.cadastro_barbeiro.shared.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record ProfessionalDTO(
        @JsonProperty("id") Long id,
        @JsonProperty("nome") @NotNull String nome,
        @JsonProperty("email") @NotNull String email,
        @JsonProperty("telefone") String telefone,
        @JsonProperty("ownerOrCollaborator")@NotNull String ownerOrCollaborator) {
}
