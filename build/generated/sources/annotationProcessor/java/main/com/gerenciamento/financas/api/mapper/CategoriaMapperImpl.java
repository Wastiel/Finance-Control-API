package com.gerenciamento.financas.api.mapper;

import com.gerenciamento.financas.api.dto.CategoriaDetail;
import com.gerenciamento.financas.api.form.CategoriaForm;
import com.gerenciamento.financas.domain.model.entity.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-12T07:52:35-0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class CategoriaMapperImpl implements CategoriaMapper {

    @Override
    public CategoriaDetail toCategoriaDetail(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        CategoriaDetail.CategoriaDetailBuilder categoriaDetail = CategoriaDetail.builder();

        categoriaDetail.id( categoria.getId() );
        categoriaDetail.descricao( categoria.getDescricao() );
        categoriaDetail.situacao( categoria.getSituacao() );

        return categoriaDetail.build();
    }

    @Override
    public List<CategoriaDetail> toListCategoriaDetail(List<Categoria> categoria) {
        if ( categoria == null ) {
            return null;
        }

        List<CategoriaDetail> list = new ArrayList<CategoriaDetail>( categoria.size() );
        for ( Categoria categoria1 : categoria ) {
            list.add( toCategoriaDetail( categoria1 ) );
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

    @Override
    public Categoria toCategoria(CategoriaForm categoriaForm) {
        if ( categoriaForm == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setId( categoriaForm.getId() );
        categoria.setDescricao( categoriaForm.getDescricao() );
        categoria.setSituacao( categoriaForm.getSituacao() );

        return categoria;
    }
}
