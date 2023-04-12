package com.gerenciamento.financas.api.exception;

import com.gerenciamento.financas.domain.model.exception.CategoriaNotFound;
import com.gerenciamento.financas.domain.model.exception.ContaNotFound;
import com.gerenciamento.financas.domain.model.exception.TransacaoNotFound;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ApiExceptionDetail handlerException(Exception e){
        log.error("Deu erro dentro exception geral");
        return new ApiExceptionDetail(HttpStatus.INTERNAL_SERVER_ERROR, "Erro geral da aplicacao");
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CategoriaNotFound.class)
    @ResponseBody
    public ApiExceptionDetail handlerCategoriaNotFoundException(CategoriaNotFound e) {
        log.warn("pediu Categoria que nao existe");
        return new ApiExceptionDetail(HttpStatus.NOT_FOUND, e.getMessage());
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ContaNotFound.class)
    @ResponseBody
    public ApiExceptionDetail handlerContaNotFoundException(ContaNotFound e) {
        log.warn("pediu Conta que nao existe");
        return new ApiExceptionDetail(HttpStatus.NOT_FOUND, e.getMessage());
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(TransacaoNotFound.class)
    @ResponseBody
    public ApiExceptionDetail handlerTransacaoFoundException(TransacaoNotFound e) {
        log.warn("pediu Conta que nao existe");
        return new ApiExceptionDetail(HttpStatus.NOT_FOUND, e.getMessage());
    }
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ApiExceptionDetail handleMethodArgumentNotValidException(BindException e) {
        log.warn("BindException: " + e.getMessage());
        return ApiExceptionDetail.valueOf(e.getBindingResult());
    }


}
