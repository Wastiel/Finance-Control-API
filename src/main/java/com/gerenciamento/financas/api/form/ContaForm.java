package com.gerenciamento.financas.api.form;

import com.gerenciamento.financas.domain.model.enums.Situacao;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
public class ContaForm {
    private long id;
    private String nome;
    @NotNull
    private double saldo;
    @Enumerated(EnumType.STRING)
    private Situacao situacao;
}
