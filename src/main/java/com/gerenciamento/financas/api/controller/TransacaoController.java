package com.gerenciamento.financas.api.controller;

import com.gerenciamento.financas.api.dto.TransacaoDetail;
import com.gerenciamento.financas.api.form.TransacaoForm;
import com.gerenciamento.financas.api.mapper.TransacaoMapper;
import com.gerenciamento.financas.domain.model.entity.Transacao;
import com.gerenciamento.financas.domain.model.service.TransacaoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacao")
@AllArgsConstructor
public class TransacaoController {

    private TransacaoService transacaoService;
    private TransacaoMapper transacaoMapper;

    @GetMapping
    public ResponseEntity<List<TransacaoDetail>> findAll(){
        List<TransacaoDetail> transacaoDetailList = transacaoMapper.toTransacaoDetailList(transacaoService.findAll());
        return ResponseEntity.ok(transacaoDetailList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TransacaoDetail>  findById(@PathVariable Long id){
        TransacaoDetail transacaoDetail = transacaoMapper.toTransacaoDetail(transacaoService.findById(id));
        return ResponseEntity.ok(transacaoDetail);
    }
    @PostMapping
    public ResponseEntity<TransacaoDetail> create(@RequestBody @Valid Transacao transacao){
        TransacaoDetail transacaoDetail = transacaoMapper.toTransacaoDetail(transacaoService.create(transacao));
        return ResponseEntity.ok(transacaoDetail);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TransacaoDetail> update(@PathVariable long id, @RequestBody TransacaoForm transacaoForm){
        return ResponseEntity.ok(transacaoMapper.toTransacaoDetail(transacaoService.update(id, transacaoMapper.toTransacao(transacaoForm))));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id){
        transacaoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
