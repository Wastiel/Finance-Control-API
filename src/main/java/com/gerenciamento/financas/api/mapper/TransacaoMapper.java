package com.gerenciamento.financas.api.mapper;

import com.gerenciamento.financas.api.dto.TransacaoDetail;
import com.gerenciamento.financas.api.form.ContaForm;
import com.gerenciamento.financas.api.form.TransacaoForm;
import com.gerenciamento.financas.domain.model.entity.Conta;
import com.gerenciamento.financas.domain.model.entity.Transacao;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransacaoMapper {
    TransacaoDetail toTransacaoDetail(Transacao transacao);
    List<TransacaoDetail> toTransacaoDetailList(List<Transacao> all);
    Transacao toTransacao(TransacaoDetail transacaoDetail);
    Transacao toTransacao(TransacaoForm transacaoForm);

}
