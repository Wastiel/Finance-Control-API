package com.gerenciamento.financas.domain.model.entity;

import com.gerenciamento.financas.domain.model.enums.TipoTransacao;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "transacao")
public class Transacao {
    @Id
    @GeneratedValue
    private long id;
    private BigDecimal valor;
    private LocalDate data;
    private String descricao;
    @ManyToOne
    @JoinColumn(referencedColumnName = "ID")
    private Conta conta;
    @ManyToOne
    @JoinColumn(referencedColumnName = "ID")
    private Categoria categoria;
    @Enumerated(EnumType.STRING)
    private TipoTransacao tipoTransacao;
}
