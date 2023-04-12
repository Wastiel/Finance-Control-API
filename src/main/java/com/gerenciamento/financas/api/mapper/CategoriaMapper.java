package com.gerenciamento.financas.api.mapper;

import com.gerenciamento.financas.api.dto.CategoriaDetail;
import com.gerenciamento.financas.api.form.CategoriaForm;
import com.gerenciamento.financas.domain.model.entity.Categoria;
import lombok.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoriaMapper {

    CategoriaDetail toCategoriaDetail(Categoria categoria);
    List<CategoriaDetail> toListCategoriaDetail(List<Categoria> categoria);
    Categoria toCategoria(CategoriaDetail categoriaDetail);
    Categoria toCategoria(CategoriaForm categoriaForm);

    //Categoria toCategoria(CategoriaForm categoriaForm) Dentro do DTO




}
