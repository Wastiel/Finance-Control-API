package com.gerenciamento.financas.api.form;

import com.gerenciamento.financas.domain.model.entity.Categoria;
import com.gerenciamento.financas.domain.model.entity.Conta;
import com.gerenciamento.financas.domain.model.enums.TipoTransacao;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
public class TransacaoForm {
    private double valor;
    private LocalDate data;
    private String descricao;
    private Conta conta;
    private Categoria categoria;
    @Enumerated(EnumType.STRING)
    private TipoTransacao tipoTransacao;

}
