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

@Component
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
        Conta contadb = contaRepository.findById(id).orElseThrow(() -> new ContaNotFound("A conta solicitada nao existe"));

        //mappares dentro do domain de conta para conta.
        contadb.setNome(conta.getNome());
        contadb.setSaldo(conta.getSaldo());
        contadb.setSituacao(conta.getSituacao());

        return contaRepository.save(contadb);
    }
    public Conta changeStatusConta(Long id, Conta conta) {
        Conta contadb = contaRepository.findById(id).orElseThrow(() ->new CategoriaNotFound("Nao encontrou o id solicitado"));
        contadb.setSituacao(conta.getSituacao());
        return contaRepository.save(contadb);
    }
    public Conta atualizaSaldo(long id) {
        // metodo caluclarSaldo ou recalcularSaldo.
        Conta contadb = contaRepository.findById(id).orElseThrow(() ->new CategoriaNotFound("Nao encontrou a conta solicitada"));
        List<Transacao> transcoes = transacaoRepository.findAllbyConta(contadb.getId());
        //List<Transacao> transcoes2 = transacaoRepository.findAllbyConta(contadb.getId());
        BigDecimal saldoTotal = BigDecimal.ZERO;

        for(Transacao transacao : transcoes){
            BigDecimal valor = transacao.getValor();
            if (transacao.getTipoTransacao() == TipoTransacao.RECEITA) {
                saldoTotal = saldoTotal.add(valor);
            } else {
                saldoTotal = saldoTotal.subtract(valor);
            }
        }
        contadb.setSaldo(saldoTotal);
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
    @Scheduled(cron = "0 08 22 * * *")
    public void atualizaSaldoHora() {
        System.out.println("entrou aqui");
        // metodo caluclarSaldo ou recalcularSaldo.
        Conta contadb = contaRepository.findById(52l).orElseThrow(() ->new CategoriaNotFound("Nao encontrou a conta solicitada"));
        contadb.setSaldo(new BigDecimal(666));
        contaRepository.save(contadb);}


}
