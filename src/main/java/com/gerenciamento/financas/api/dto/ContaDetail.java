package com.gerenciamento.financas.api.dto;

import com.gerenciamento.financas.domain.model.enums.Situacao;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ContaDetail {
    private long id;

    private String nome;
    @NotNull
    private double saldo;
    @Enumerated(EnumType.STRING)
    private Situacao situacao;
}
