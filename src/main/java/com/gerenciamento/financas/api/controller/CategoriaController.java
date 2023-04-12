package com.gerenciamento.financas.api.controller;

import com.gerenciamento.financas.api.dto.CategoriaDetail;
import com.gerenciamento.financas.api.mapper.CategoriaMapper;
import com.gerenciamento.financas.domain.model.entity.Categoria;
import com.gerenciamento.financas.domain.model.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@AllArgsConstructor
public class CategoriaController {
    private CategoriaService categoriaService;
    private CategoriaMapper categoriaMapper;

    @GetMapping
    public ResponseEntity<List<CategoriaDetail>>  findAll(){
        List<CategoriaDetail> categoriaDetails = categoriaMapper.toListCategoriaDetail(categoriaService.findAll());
        return ResponseEntity.ok(categoriaDetails);
   }
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDetail> findById(@PathVariable Long id){
        CategoriaDetail categoriaDetails = categoriaMapper.toCategoriaDetail(categoriaService.findById(id));
        return ResponseEntity.ok(categoriaDetails);
    }

    @PostMapping
    public ResponseEntity<CategoriaDetail> create(@Valid @RequestBody CategoriaDetail categoriaDetail){
        //categoria from o que vai entrar, o que precisa passar para criar objetvo.
        //Recebo Categoria Mapper
        CategoriaDetail categoriaDetails = categoriaMapper.toCategoriaDetail(categoriaService.create(categoriaMapper.toCategoria(categoriaDetail)));
        return ResponseEntity.ok(categoriaDetails);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria categoria){
        return ResponseEntity.ok(categoriaService.update(id, categoria));
    }
    @PutMapping("/{id}/changeStatus")
    public ResponseEntity<Categoria> changeStatusCategoria(@PathVariable Long id, @RequestBody Categoria categoria){
        return ResponseEntity.ok(categoriaService.changeStatusCategoria(id, categoria));
    }
}
