package com.gerenciamento.financas.domain.model.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CategoriaNotFound extends RuntimeException{
    public CategoriaNotFound(String message){

        super(message);

    }

}
