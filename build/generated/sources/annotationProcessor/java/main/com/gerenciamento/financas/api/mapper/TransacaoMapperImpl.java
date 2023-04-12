package com.gerenciamento.financas.api.mapper;

import com.gerenciamento.financas.api.dto.TransacaoDetail;
import com.gerenciamento.financas.domain.model.entity.Transacao;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-12T06:04:09-0300",
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
}
