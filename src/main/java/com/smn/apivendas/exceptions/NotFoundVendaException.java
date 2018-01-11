package com.smn.apivendas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "venda não existe para manipulação dos itens")
public class NotFoundVendaException extends RuntimeException {

}
