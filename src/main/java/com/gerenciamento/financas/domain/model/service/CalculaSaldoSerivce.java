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

    public Conta atualizarSaldoPorConta(long id) {
        Conta conta = contaRepository.findById(id)
                .orElseThrow(() -> new CategoriaNotFound("Nao encontrou a conta solicitada"));

        List<Transacao> transacoes = transacaoRepository.findAllbyConta(conta.getId());

        BigDecimal saldoTotal = BigDecimal.ZERO;

        for(Transacao transacao : transacoes){
            BigDecimal valor = transacao.getValor();
            if (transacao.getTipoTransacao() == TipoTransacao.RECEITA) {
                saldoTotal = saldoTotal.add(valor);
            } else {
                saldoTotal = saldoTotal.subtract(valor);
            }
        }

        conta.setSaldo(saldoTotal);

        return contaRepository.save(conta);
    }
    public Conta atualizarSaldoPorTransacao(Transacao transacao) {
        Conta conta = contaRepository.findById(transacao.getConta().getId())
                .orElseThrow(() -> new CategoriaNotFound("Nao encontrou a conta solicitada"));

        BigDecimal saldoTotal = conta.getSaldo();

        if (transacao.getTipoTransacao() == TipoTransacao.RECEITA) {
            conta.setSaldo(saldoTotal.add(transacao.getValor()));
        } else {
            conta.setSaldo(saldoTotal.subtract(transacao.getValor()));
        }

        return contaRepository.save(conta);
    }
    @Scheduled(cron = "0 08 22 * * *")
    public void calcularSaldoDeTodasAsContas() {
        List<Conta> contas = contaRepository.findAll();

        for (Conta conta : contas) {
            BigDecimal saldoTotal = calcularSaldo(conta);

            conta.setSaldo(saldoTotal);

            contaRepository.save(conta);
        }
    }
    private BigDecimal calcularSaldo(Conta conta) {
        List<Transacao> transacoes = transacaoRepository.findAllbyConta(conta.getId());

        BigDecimal saldoTotal = BigDecimal.ZERO;

        for (Transacao transacao : transacoes) {
            BigDecimal valor = transacao.getValor();

            if (transacao.getTipoTransacao() == TipoTransacao.RECEITA) {
                saldoTotal = saldoTotal.add(valor);
            } else {
                saldoTotal = saldoTotal.subtract(valor);
            }
        }

        return saldoTotal;
    }



}
