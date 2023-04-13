package com.gerenciamento.financas.api.form;

import com.gerenciamento.financas.domain.model.enums.Situacao;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
public class CategoriaForm {

    private long id;
    @NotBlank(message = "O valor nao pode ser branco")
    private String descricao;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Situacao situacao;

}
