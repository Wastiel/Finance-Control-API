package com.gerenciamento.financas.api.controller;

import com.gerenciamento.financas.api.dto.ContaDetail;
import com.gerenciamento.financas.api.form.ContaForm;
import com.gerenciamento.financas.api.mapper.ContaMapper;
import com.gerenciamento.financas.domain.model.entity.Conta;
import com.gerenciamento.financas.domain.model.service.CalculaSaldoSerivce;
import com.gerenciamento.financas.domain.model.service.ContaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conta")
@AllArgsConstructor
public class ContaController {
    private ContaService contaService;
    private CalculaSaldoSerivce calculaSaldoSerivce;
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
    public ResponseEntity<ContaDetail> create(@RequestBody @Validated ContaForm contaForm){
        ContaDetail contaDetail = contaMapper.toContaDetail(contaService.create(contaMapper.toConta(contaForm)));
        return ResponseEntity.ok(contaDetail);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ContaDetail> update(@PathVariable long id, @RequestBody @Validated ContaForm contaForm){
        return ResponseEntity.ok(contaMapper.toContaDetail(contaService.update(id, contaMapper.toConta(contaForm))));
    }
    @PutMapping("/{id}/calculateBalance")
    public ResponseEntity<ContaDetail> calculateBalance(@PathVariable long id){
        return ResponseEntity.ok(contaMapper.toContaDetail(calculaSaldoSerivce.calculateBalance(id)));
    }
    @PutMapping("/saldo")
    public ResponseEntity calcularaSaldoContas(@PathVariable long id){
        return ResponseEntity.ok(contaService.calcularSaldo(id));
    }
    /*@PutMapping("/saldo")
    public ResponseEntity calcularaSaldoContas(@PathVariable List<id>){
        return ResponseEntity.ok(contaService.calcularSaldo(List<id>);
    }*/

}
