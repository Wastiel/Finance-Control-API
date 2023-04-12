package com.gerenciamento.financas.domain.model.service;

import com.gerenciamento.financas.domain.model.entity.Conta;
import com.gerenciamento.financas.domain.model.entity.Transacao;
import com.gerenciamento.financas.domain.model.exception.CategoriaNotFound;
import com.gerenciamento.financas.domain.model.exception.TransacaoNotFound;
import com.gerenciamento.financas.domain.model.repository.ContaRepository;
import com.gerenciamento.financas.domain.model.repository.TransacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class TransacaoService {
    private TransacaoRepository transacaoRepository;
    private final ContaService contaService;

    public List<Transacao> findAll(){
        return transacaoRepository.findAll();
    }
    public Transacao findById(long id){
        return transacaoRepository.findById(id).orElseThrow(() -> new TransacaoNotFound("A transacao solicitada nao existe."));
    }
    public Transacao create(Transacao transacao){
        contaService.atualizaSaldo(transacao);
        return transacaoRepository.save(transacao);
    }
    public Transacao update(long id, Transacao transacao){
        Transacao transacaodb = transacaoRepository.findById(id).orElseThrow(() -> new TransacaoNotFound("A transacao solicitada nao existe."));
        return transacaoRepository.save(transacaodb);
    }
    public void delete(Long id){
        Transacao transacaodb = transacaoRepository.findById(id).orElseThrow(() -> new TransacaoNotFound("A transacao solicitada nao existe."));
        contaService.atualizaSaldo(transacaodb);
        transacaoRepository.deleteById(id);
    }
}
