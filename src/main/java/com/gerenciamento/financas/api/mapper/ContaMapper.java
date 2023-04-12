package com.gerenciamento.financas.api.mapper;

import com.gerenciamento.financas.api.dto.ContaDetail;
import com.gerenciamento.financas.api.form.CategoriaForm;
import com.gerenciamento.financas.api.form.ContaForm;
import com.gerenciamento.financas.domain.model.entity.Categoria;
import com.gerenciamento.financas.domain.model.entity.Conta;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContaMapper {
    ContaDetail toContaDetail(Conta conta);
    List<ContaDetail> toListContaDetail(List<Conta> contas);
    Conta toConta(ContaForm contaForm);
    Conta toConta(ContaDetail contaDetail);
}
