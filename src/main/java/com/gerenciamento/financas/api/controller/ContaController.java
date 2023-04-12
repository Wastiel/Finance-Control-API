package com.gerenciamento.financas.api.controller;

import com.gerenciamento.financas.api.dto.ContaDetail;
import com.gerenciamento.financas.api.mapper.ContaMapper;
import com.gerenciamento.financas.domain.model.entity.Conta;
import com.gerenciamento.financas.domain.model.service.ContaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conta")
@AllArgsConstructor
public class ContaController {
    private ContaService contaService;
    private ContaMapper contaMapper;

    @GetMapping
    public ResponseEntity<List<ContaDetail>> findAll(){
        List<ContaDetail> contaDetails = contaMapper.toListContaDetail(contaService.findAll());
        return ResponseEntity.ok(contaDetails);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ContaDetail> findById(@PathVariable Long id){
        ContaDetail contaDetails = contaMapper.toContaDetail(contaService.findById(id));
        return ResponseEntity.ok(contaDetails);
    }
    @PostMapping
    public ResponseEntity<ContaDetail> create(@RequestBody @Valid Conta conta){
        ContaDetail contaDetail = contaMapper.toContaDetail(contaService.create(conta));
        return ResponseEntity.ok(contaDetail);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Conta> update(@PathVariable long id, @RequestBody Conta conta){
        return ResponseEntity.ok(contaService.update(id, conta));
    }
    @PutMapping("/{id}/changeStatus")
    public ResponseEntity<Conta> changeStatusConta(@PathVariable long id, @RequestBody Conta conta){
        return ResponseEntity.ok(contaService.changeStatusConta(id, conta));
    }

    @PutMapping("/{id}/atualizaSaldo")
    public ResponseEntity atualizaSaldo(@PathVariable long id){
        return ResponseEntity.ok(contaService.atualizaSaldo(id));
    }

}
