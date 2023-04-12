package com.gerenciamento.financas.domain.model.repository;

import com.gerenciamento.financas.domain.model.entity.Conta;
import com.gerenciamento.financas.domain.model.entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    @Query("SELECT t FROM Transacao t WHERE t.conta.ID = :test")
    List<Transacao> findAllbyConta(@Param("test") long id);

    //@Query(value = "SELECT t FROM Transacao t WHERE t.conta.ID = :test", nativeQuery = true)
}
