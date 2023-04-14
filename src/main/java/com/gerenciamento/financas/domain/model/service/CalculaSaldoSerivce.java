package com.gerenciamento.financas.domain.model.service;

import com.gerenciamento.financas.domain.model.entity.Conta;
import com.gerenciamento.financas.domain.model.entity.Transacao;
import com.gerenciamento.financas.domain.model.enums.TipoTransacao;
import com.gerenciamento.financas.domain.model.exception.CategoriaNotFound;
import com.gerenciamento.financas.domain.model.repository.ContaRepository;
import com.gerenciamento.financas.domain.model.repository.TransacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@AllArgsConstructor
public class CalculaSaldoSerivce {
    private final ContaRepository contaRepository;
    private final TransacaoRepository transacaoRepository;

    public Conta calculateBalance(long id) {
        Conta conta = contaRepository.findById(id).orElseThrow(() -> new CategoriaNotFound("Nao encontrou a conta solicitada"));
        List<Transacao> transacoes = transacaoRepository.findAllbyConta(conta.getId());

        conta.setSaldo(BigDecimal.ZERO);

        for (Transacao transacao : transacoes) {
            if (transacao.getTipoTransacao() == TipoTransacao.RECEITA) {
                conta.deposit(transacao.getValor());
            } else {
                conta.withdraw(transacao.getValor());
            }
        }
        return contaRepository.save(conta);
    }
    public void calculateAccountsBalance(List<Long> ids) {
        for(Long id: ids){
            calculateBalance(id);
        }
    }
    @Scheduled(cron = "0 08 22 * * *")
    public void calculateAllAccountsBalance() {
        List<Conta> contas = contaRepository.findAll();

        for (Conta conta : contas) {
            calculateBalance(conta.getId());
        }
    }
    /*public BigDecimal updateBalanceByTransaction(Transacao transacao) {
        if (transacao.getTipoTransacao() == TipoTransacao.RECEITA) {
            conta.deposit(transacao.getValor());
        } else {
            conta.withdraw(transacao.getValor());
        }
        return conta.getSaldo();
    }*/




}
