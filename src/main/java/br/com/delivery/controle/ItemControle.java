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

import br.com.delivery.dto.ItemDto;
import br.com.delivery.servico.ItemServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemControle {

	private final ItemServico itemServico;
	
	
	@PostMapping("{pedidoId}")
	@Operation(summary = "Endpoint responsável por cadastrar um item pelo id do pedido.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<ItemDto>criarItem(@RequestBody ItemDto itemDto,@PathVariable("pedidoId")Long pedidoId){
		var criar = itemServico.criarItem(itemDto, pedidoId);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
		buildAndExpand(criar.getId()).toUri();
		return ResponseEntity.created(uri).body(new ItemDto(criar));
	}
	
	
	@GetMapping
	@Operation(summary = "Endpoint responsável por buscar todos os itens.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<List<ItemDto>>buscarItens(){
		var buscar = itemServico.buscarItens();
		return ResponseEntity.ok().body(buscar);
	}
	
	
	@GetMapping("{id}")
	@Operation(summary = "Endpoint responsável por buscar itens pelo id.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<ItemDto>buscarPorId(@PathVariable Long id){
		var buscarId = itemServico.buscarPorId(id);
		return ResponseEntity.ok().body(new ItemDto(buscarId));
	}
	
	
	@PutMapping("{id}")
	@Operation(summary = "Endpoint responsável por atualizar item pelo id.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<ItemDto>atualizarItem(@RequestBody ItemDto itemDto,@PathVariable Long id){
		var atualizar = itemServico.atualizarItem(itemDto, id);
		return ResponseEntity.ok().body(new ItemDto(atualizar));
	}
	
	
	@DeleteMapping
	@Operation(summary = "Endpoint responsável por excluir item.") 
    @ApiResponse(responseCode = "204",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<Void>excluirPedido(@PathVariable Long id){
		itemServico.excluirItem(id);
		return ResponseEntity.noContent().build();
	}
}
