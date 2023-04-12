package com.gerenciamento.financas.api.dto;

import com.gerenciamento.financas.domain.model.entity.Categoria;
import com.gerenciamento.financas.domain.model.enums.Situacao;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.mapstruct.Mapper;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CategoriaDetail {

    private long id;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Situacao situacao;

}
