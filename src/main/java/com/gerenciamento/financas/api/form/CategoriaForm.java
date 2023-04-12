package com.gerenciamento.financas.api.form;

import com.gerenciamento.financas.domain.model.enums.Situacao;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
public class CategoriaForm {

    private long id;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Situacao situacao;

}
