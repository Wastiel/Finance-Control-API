package com.gerenciamento.financas.domain.model.repository;

import com.gerenciamento.financas.domain.model.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {


}
