package com.gerenciamento.financas.domain.model.service;

import com.gerenciamento.financas.api.dto.CategoriaDetail;
import com.gerenciamento.financas.domain.model.entity.Categoria;
import com.gerenciamento.financas.domain.model.entity.Transacao;
import com.gerenciamento.financas.domain.model.exception.CategoriaNotFound;
import com.gerenciamento.financas.domain.model.repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }
    public Categoria findById(Long id){
        return categoriaRepository.findById(id).orElseThrow(() ->new CategoriaNotFound("Nao encontrou o id solicitado"));
    }
    public Categoria create(Categoria categoria){
        return categoriaRepository.save(categoria);
    }
    public Categoria update(long id, Categoria categoria){
        findById(id);
        categoria.setId(id);
        return categoriaRepository.save(categoria);
    }
    public Categoria changeStatusCategoria(long id, Categoria categoria){
        findById(id);
        categoria.setId(id);
        return categoriaRepository.save(categoria);
    }
}
