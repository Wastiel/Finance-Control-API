package com.gerenciamento.financas.domain.model.entity;


import com.gerenciamento.financas.domain.model.enums.Situacao;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue
    private long id;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Situacao situacao;
}
