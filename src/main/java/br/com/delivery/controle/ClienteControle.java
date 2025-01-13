package br.com.delivery.controle;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.delivery.dto.AtualizarDto;
import br.com.delivery.dto.BuscarClienteDto;
import br.com.delivery.dto.ClienteDtO;
import br.com.delivery.servico.ClienteServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteControle {

	private final ClienteServico clienteServico;
	
	@PostMapping
	@Operation(summary = "Endpoint responsável por cadastrar clientes.") 
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<ClienteDtO>cadastrarCliente(@RequestBody ClienteDtO clienteDtO){
		var cadastrar = clienteServico.cadastrarCliente(clienteDtO);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
			buildAndExpand(cadastrar.getId()).toUri();	
		return ResponseEntity.created(uri).body(new ClienteDtO(cadastrar));
	}
	
	
	@GetMapping
	@Operation(summary = "Endpoint responsável por buscar todos os clientes.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<List<BuscarClienteDto>>buscarClientes(){
		var busca = clienteServico.buscarClientes();
		return ResponseEntity.ok().body(busca);
	}
	
	@GetMapping("{id}")
	@Operation(summary = "Endpoint responsável pela busca de clientes pelo id.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<BuscarClienteDto>buscarPorId(@PathVariable Long id){
		var buscaId = clienteServico.buscarPorId(id);
		return ResponseEntity.ok().body(new BuscarClienteDto(buscaId));
	}
	
	@GetMapping("nome")
	@Operation(summary = "Endpoint responsável pela busca de clientes pelo nome ou parte dele.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<List<BuscarClienteDto>>buscarPorNome(@RequestParam("nome")String nome){
	var buscaNome = clienteServico.buscarPorNome(nome);
	return ResponseEntity.ok().body(buscaNome.stream().map(BuscarClienteDto::new).toList());
	
	
		
	}
	
	@PutMapping("{id}")
	@Operation(summary = "Endpoint responsável por atualizar clientes pelo id.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<AtualizarDto>atualizarCliente(@RequestBody AtualizarDto atualizarDto,@PathVariable Long id){		
		var atualizar = clienteServico.atualizarCliente(atualizarDto, id);
		return ResponseEntity.ok().body(new AtualizarDto(atualizar));
	}
	
	
	
	@DeleteMapping("{id}")
	@Operation(summary = "Endpoint responsável por excluir clientes id.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<Void>excluirCliente(@PathVariable Long id){
		clienteServico.excluirCliente(id);
		return ResponseEntity.noContent().build();
	}
}
	
