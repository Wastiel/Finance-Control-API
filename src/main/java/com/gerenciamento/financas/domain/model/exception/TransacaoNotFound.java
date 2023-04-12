package com.gerenciamento.financas.domain.model.exception;

import lombok.NoArgsConstructor;
@NoArgsConstructor
public class TransacaoNotFound extends RuntimeException{
    public TransacaoNotFound(String message) {
        super(message);
    }
}
