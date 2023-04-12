package com.gerenciamento.financas.api.mapper;

import com.gerenciamento.financas.api.dto.CategoriaDetail;
import com.gerenciamento.financas.domain.model.entity.Categoria;
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
public class CategoriaMapperImpl implements CategoriaMapper {

    @Override
    public CategoriaDetail toCategoriaDetail(Categoria form) {
        if ( form == null ) {
            return null;
        }

        CategoriaDetail.CategoriaDetailBuilder categoriaDetail = CategoriaDetail.builder();

        categoriaDetail.id( form.getId() );
        categoriaDetail.descricao( form.getDescricao() );
        categoriaDetail.situacao( form.getSituacao() );

        return categoriaDetail.build();
    }

    @Override
    public List<CategoriaDetail> toListCategoriaDetail(List<Categoria> all) {
        if ( all == null ) {
            return null;
        }

        List<CategoriaDetail> list = new ArrayList<CategoriaDetail>( all.size() );
        for ( Categoria categoria : all ) {
            list.add( toCategoriaDetail( categoria ) );
        }

        return list;
    }

    @Override
    public Categoria toCategoria(CategoriaDetail categoriaDetail) {
        if ( categoriaDetail == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setId( categoriaDetail.getId() );
        categoria.setDescricao( categoriaDetail.getDescricao() );
        categoria.setSituacao( categoriaDetail.getSituacao() );

        return categoria;
    }
}
