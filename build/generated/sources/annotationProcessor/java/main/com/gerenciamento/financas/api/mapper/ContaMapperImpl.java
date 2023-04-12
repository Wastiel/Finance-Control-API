package com.gerenciamento.financas.api.mapper;

import com.gerenciamento.financas.api.dto.ContaDetail;
import com.gerenciamento.financas.domain.model.entity.Conta;
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
public class ContaMapperImpl implements ContaMapper {

    @Override
    public ContaDetail toContaDetail(Conta form) {
        if ( form == null ) {
            return null;
        }

        ContaDetail.ContaDetailBuilder contaDetail = ContaDetail.builder();

        contaDetail.id( form.getId() );
        contaDetail.nome( form.getNome() );
        if ( form.getSaldo() != null ) {
            contaDetail.saldo( form.getSaldo().doubleValue() );
        }
        contaDetail.situacao( form.getSituacao() );

        return contaDetail.build();
    }

    @Override
    public List<ContaDetail> toListContaDetail(List<Conta> all) {
        if ( all == null ) {
            return null;
        }

        List<ContaDetail> list = new ArrayList<ContaDetail>( all.size() );
        for ( Conta conta : all ) {
            list.add( toContaDetail( conta ) );
        }

        return list;
    }
}
