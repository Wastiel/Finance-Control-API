package com.gerenciamento.financas.domain.model.exception;

import lombok.NoArgsConstructor;
@NoArgsConstructor
public class ContaNotFound extends RuntimeException{
    public ContaNotFound(String message){
        super(message);
    }
}
