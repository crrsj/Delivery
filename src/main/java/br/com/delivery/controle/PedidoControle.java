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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.delivery.dto.PedidoDto;
import br.com.delivery.servico.PedidoServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoControle {

	private final PedidoServico pedidoServico;
	
	
	@PostMapping("{clienteId}")
	@Operation(summary = "Endpoint responsável por caadstrar pedido pelo id do cliente.") 
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<PedidoDto>criarPedido(@RequestBody PedidoDto pedidoDto,@PathVariable("clienteId")Long clienteId){
		var criarPedido = pedidoServico.criarpedido(pedidoDto, clienteId);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").
		buildAndExpand(criarPedido.getId()).toUri();
		return ResponseEntity.created(uri).body(new PedidoDto(criarPedido));
		
	}
	
	@GetMapping
	@Operation(summary = "Endpoint responsável por buscar todos os pedidos.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<List<PedidoDto>>buscarPedidos(){
		var buscar = pedidoServico.buscarPedidos();
		return ResponseEntity.ok().body(buscar);
	}
	
	
	@GetMapping("{id}")
	@Operation(summary = "Endpoint responsável por buscar pedido pelo id.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<PedidoDto>buscarPorId(@PathVariable Long id){
		var buscarId = pedidoServico.buscarPorId(id);
		return ResponseEntity.ok().body(new PedidoDto(buscarId));
	}
	
	
	@PutMapping("{id}")
	@Operation(summary = "Endpoint responsável por atualizar pedido pelo id.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<PedidoDto>atualizarPedido(@RequestBody PedidoDto pedidoDto,@PathVariable Long id){
		var atualize = pedidoServico.atualizarPedido(pedidoDto, id);
		return ResponseEntity.ok().body(new PedidoDto(atualize));
	}
	
	
	@DeleteMapping
	@Operation(summary = "Endpoint responsável por excluir pedido.") 
    @ApiResponse(responseCode = "204",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<Void>excluirPedido(@PathVariable Long id){
		pedidoServico.excluirPedidos(id);
		return ResponseEntity.noContent().build();
	}
}
