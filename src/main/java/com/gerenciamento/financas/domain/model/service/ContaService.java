package com.gerenciamento.financas.domain.model.service;

import com.gerenciamento.financas.domain.model.entity.Conta;
import com.gerenciamento.financas.domain.model.entity.Transacao;
import com.gerenciamento.financas.domain.model.enums.TipoTransacao;
import com.gerenciamento.financas.domain.model.exception.CategoriaNotFound;
import com.gerenciamento.financas.domain.model.exception.ContaNotFound;
import com.gerenciamento.financas.domain.model.repository.ContaRepository;
import com.gerenciamento.financas.domain.model.repository.TransacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@AllArgsConstructor
@Service
public class ContaService {

    private final ContaRepository contaRepository;
    private final TransacaoRepository transacaoRepository;

    public List<Conta> findAll(){
        return contaRepository.findAll();
    }
    public Conta findById(long id){
        return contaRepository.findById(id).orElseThrow(() -> new ContaNotFound("O id relacionado a conta solicitada nao existe."));
    }
    public Conta create(Conta conta){
        return contaRepository.save(conta);
    }
    public Conta update(long id, Conta conta){
        findById(id);
        conta.setId(id);
        return contaRepository.save(conta);
    }
    /*public Conta changeStatusConta(Long id, Conta conta) {
        //Conta contadb = contaRepository.findById(id).orElseThrow(() ->new CategoriaNotFound("Nao encontrou o id solicitado"));
        conta.setId(id);
        return contaRepository.save(conta);
    }*/
    public Conta calcularSaldo(long id) {
        // metodo caluclarSaldo ou recalcularSaldo.
        Conta contadb = contaRepository.findById(id).orElseThrow(() ->new CategoriaNotFound("Nao encontrou a conta solicitada"));
        return contaRepository.save(contadb);
    }
    public Conta atualizaSaldo(Transacao transacao){
        Conta contadb = contaRepository.findById(transacao.getConta().getId()).orElseThrow(() ->new CategoriaNotFound("Nao encontrou a conta solicitada"));
        BigDecimal saldoTotal = contadb.getSaldo();
            if (transacao.getTipoTransacao() == TipoTransacao.RECEITA) {
                contadb.setSaldo(saldoTotal.add(transacao.getValor()));
            } else {
                contadb.setSaldo(saldoTotal.subtract(transacao.getValor()));
            }
        return contaRepository.save(contadb);
    }

    /*public void atualizaSaldoHora() {
        System.out.println("entrou aqui");
        // metodo caluclarSaldo ou recalcularSaldo.
        Conta contadb = contaRepository.findById(52l).orElseThrow(() ->new CategoriaNotFound("Nao encontrou a conta solicitada"));
        contadb.setSaldo(new BigDecimal(666));
        contaRepository.save(contadb);}*/


}
