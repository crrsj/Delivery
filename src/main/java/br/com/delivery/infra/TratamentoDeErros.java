package br.com.delivery.infra;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.delivery.dto.MensagensDeErro;
import br.com.delivery.dto.ValidandoCampos;

@ControllerAdvice
public class TratamentoDeErros {
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<MensagensDeErro>objetoNaoEncontrado(){
		var mensagem = new MensagensDeErro(HttpStatus.NOT_FOUND, "Objeto não encontrado");
		return new ResponseEntity<>(mensagem,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?>validarCampos(MethodArgumentNotValidException ex){
		var erros = ex.getFieldErrors();
		return ResponseEntity.badRequest().body(erros.stream().map(ValidandoCampos::new).toList());
	}

}
