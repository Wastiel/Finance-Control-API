package com.gerenciamento.financas.api.form;

import com.gerenciamento.financas.domain.model.entity.Categoria;
import com.gerenciamento.financas.domain.model.entity.Conta;
import com.gerenciamento.financas.domain.model.enums.TipoTransacao;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Getter
@Setter
public class TransacaoForm {

    @Digits(integer = 8, fraction = 2, message = "Valor invalido para o campo valor")
    private double valor;
    @NotNull(message = "A data nao pode ser nula")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;
    @NotBlank
    private String descricao;
    @NotNull
    private Conta conta;
    @NotNull
    private Categoria categoria;
    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoTransacao tipoTransacao;

}
