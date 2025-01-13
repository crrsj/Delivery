package br.com.delivery.dto;

import org.springframework.http.HttpStatus;

public record MensagensDeErro(HttpStatus status,String Mensagem) {

}
