package com.gerenciamento.financas.api.mapper;

import com.gerenciamento.financas.api.dto.TransacaoDetail;
import com.gerenciamento.financas.api.form.TransacaoForm;
import com.gerenciamento.financas.domain.model.entity.Transacao;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-12T21:44:59-0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class TransacaoMapperImpl implements TransacaoMapper {

    @Override
    public TransacaoDetail toTransacaoDetail(Transacao transacao) {
        if ( transacao == null ) {
            return null;
        }

        TransacaoDetail.TransacaoDetailBuilder transacaoDetail = TransacaoDetail.builder();

        if ( transacao.getValor() != null ) {
            transacaoDetail.valor( transacao.getValor().doubleValue() );
        }
        transacaoDetail.data( transacao.getData() );
        transacaoDetail.descricao( transacao.getDescricao() );
        transacaoDetail.conta( transacao.getConta() );
        transacaoDetail.categoria( transacao.getCategoria() );
        transacaoDetail.tipoTransacao( transacao.getTipoTransacao() );

        return transacaoDetail.build();
    }

    @Override
    public List<TransacaoDetail> toTransacaoDetailList(List<Transacao> all) {
        if ( all == null ) {
            return null;
        }

        List<TransacaoDetail> list = new ArrayList<TransacaoDetail>( all.size() );
        for ( Transacao transacao : all ) {
            list.add( toTransacaoDetail( transacao ) );
        }

        return list;
    }

    @Override
    public Transacao toTransacao(TransacaoDetail transacaoDetail) {
        if ( transacaoDetail == null ) {
            return null;
        }

        Transacao transacao = new Transacao();

        transacao.setValor( BigDecimal.valueOf( transacaoDetail.getValor() ) );
        transacao.setData( transacaoDetail.getData() );
        transacao.setDescricao( transacaoDetail.getDescricao() );
        transacao.setConta( transacaoDetail.getConta() );
        transacao.setCategoria( transacaoDetail.getCategoria() );
        transacao.setTipoTransacao( transacaoDetail.getTipoTransacao() );

        return transacao;
    }

    @Override
    public Transacao toTransacao(TransacaoForm transacaoForm) {
        if ( transacaoForm == null ) {
            return null;
        }

        Transacao transacao = new Transacao();

        transacao.setValor( BigDecimal.valueOf( transacaoForm.getValor() ) );
        transacao.setData( transacaoForm.getData() );
        transacao.setDescricao( transacaoForm.getDescricao() );
        transacao.setConta( transacaoForm.getConta() );
        transacao.setCategoria( transacaoForm.getCategoria() );
        transacao.setTipoTransacao( transacaoForm.getTipoTransacao() );

        return transacao;
    }
}
