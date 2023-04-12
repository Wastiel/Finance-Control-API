package com.gerenciamento.financas.api.controller;

import com.gerenciamento.financas.api.dto.CategoriaDetail;
import com.gerenciamento.financas.api.form.CategoriaForm;
import com.gerenciamento.financas.api.mapper.CategoriaMapper;
import com.gerenciamento.financas.domain.model.entity.Categoria;
import com.gerenciamento.financas.domain.model.service.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<CategoriaDetail> create(@RequestBody CategoriaForm categoriaForm){
        //categoria from o que vai entrar, o que precisa passar para criar objetvo.
        //Recebo Categoria Mapper
        CategoriaDetail categoriaDetails = categoriaMapper.toCategoriaDetail(categoriaService.create(categoriaMapper.toCategoria(categoriaForm)));
        return ResponseEntity.ok(categoriaDetails);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDetail> update(@PathVariable long id, @RequestBody CategoriaForm categoriaForm){
        return ResponseEntity.ok(categoriaMapper.toCategoriaDetail(categoriaService.update(id, categoriaMapper.toCategoria(categoriaForm))));
    }
    @PutMapping("/{id}/changeStatus")
    public ResponseEntity<CategoriaDetail> changeStatusCategoria(@PathVariable long id, @RequestBody CategoriaForm categoriaForm){
        return ResponseEntity.ok(categoriaMapper.toCategoriaDetail(categoriaService.changeStatusCategoria(id, categoriaMapper.toCategoria(categoriaForm))));
    }
 
}
