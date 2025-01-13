package br.com.delivery.controle;

import java.net.URI;
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

import br.com.delivery.dto.RestauranteDto;
import br.com.delivery.servico.RestauranteServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/restaurante")
@RequiredArgsConstructor
public class RestauranteControle {

	private final RestauranteServico restauranteServico;
	
	
	@PostMapping
	@Operation(summary = "Endpoint responsável por cadastrar todos os restaurantes.") 
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<RestauranteDto>cadastrarRestaurante(@RequestBody @Valid RestauranteDto restauranteDto){
		var cadastrar = restauranteServico.cadastrarRestaurante(restauranteDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").
		buildAndExpand(cadastrar.getId()).toUri();
		return ResponseEntity.created(uri).body(new RestauranteDto(cadastrar));
	}
	
	
	@GetMapping
	@Operation(summary = "Endpoint responsável por buscar todos os restaurantes.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<List<RestauranteDto>>buscarRestaurantes(){
		var buscar = restauranteServico.buscarRestaurantes();
		return ResponseEntity.ok().body(buscar);
	}
	
	
	@GetMapping("{id}")
	@Operation(summary = "Endpoint responsável por buscar restaurante pelo id.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<RestauranteDto>buscarPorId(@PathVariable Long id){
		var buscarId = restauranteServico.buscarPorId(id);
		return ResponseEntity.ok().body(new RestauranteDto(buscarId));
	}
	
	
	@PutMapping("{id}")
	@Operation(summary = "Endpoint responsável por atualizar restaurantes pelo id.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<RestauranteDto>atualizarRestaurante(@RequestBody RestauranteDto restauranteDto,@PathVariable Long id){
		var atualizar = restauranteServico.atualizarRestaurante(restauranteDto, id);
		return ResponseEntity.ok(new RestauranteDto(atualizar));
	}
	
	@DeleteMapping("{id}")
	@Operation(summary = "Endpoint responsável por excluir restaurante.") 
    @ApiResponse(responseCode = "204",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<Void>excluirRestaurante(@PathVariable Long id){
		restauranteServico.excluirRestaurante(id);
		return ResponseEntity.noContent().build();
	}
}
