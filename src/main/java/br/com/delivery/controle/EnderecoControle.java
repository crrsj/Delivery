package br.com.delivery.controle;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.delivery.dto.EnderecoDto;
import br.com.delivery.servico.EnderecoServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/endereco")
@RequiredArgsConstructor
public class EnderecoControle {
	
	private final EnderecoServico enderecoServico;
	
	
	
	@PostMapping("{clienteId}")
	@Operation(summary = "Endpoint responsável por cadastrar endereço pelo id do cliente.") 
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<EnderecoDto>cadastrarEndereco(@RequestBody EnderecoDto enderecoDto,
			@PathVariable("clienteId") Long clienteId){
		var cadastrar = enderecoServico.cadastrarEndereco(enderecoDto, clienteId);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}")	
		.buildAndExpand(cadastrar.getId()).toUri();
		return ResponseEntity.created(uri).body(new EnderecoDto(cadastrar));
	
	}
	
	@PutMapping
	@Operation(summary = "Endpoint responsável por atualizar endereço.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<EnderecoDto>atualizarEndereco(@RequestBody EnderecoDto enderecoDto,@PathVariable Long id){
		var atualizar = enderecoServico.atualizarEndereco(enderecoDto, id);
		return ResponseEntity.ok().body(new EnderecoDto(atualizar));
	}

}
