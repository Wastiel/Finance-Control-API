package com.gerenciamento.financas.domain.model.entity;

import com.gerenciamento.financas.domain.model.enums.Situacao;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "conta")
public class Conta {
    @Id
    @GeneratedValue
    private long id;
    @NotBlank
    private String nome;
    @NotNull
    private BigDecimal saldo;
    @Enumerated(EnumType.STRING)
    private Situacao situacao;

}
