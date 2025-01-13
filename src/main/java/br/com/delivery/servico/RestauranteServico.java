package br.com.delivery.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.delivery.dto.RestauranteDto;
import br.com.delivery.entidade.Restaurante;
import br.com.delivery.repositorio.RestauranteRepositorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestauranteServico {

	private final RestauranteRepositorio restauranteRepositorio;
	
	public Restaurante cadastrarRestaurante(RestauranteDto restauranteDto) {
		var cadastrar = new Restaurante(restauranteDto);
		return restauranteRepositorio.save(cadastrar);
	}
	
	public List<RestauranteDto>buscarRestaurantes(){
		return restauranteRepositorio.findAll().stream().map(RestauranteDto::new).toList();
	}
	
	public Restaurante buscarPorId(Long id) {
		Optional<Restaurante>buscar = restauranteRepositorio.findById(id);
		return buscar.get();
	}
	
	public Restaurante atualizarRestaurante(RestauranteDto restauranteDto,Long id) {
		var atualizar = new Restaurante(restauranteDto);
		atualizar.setId(id);
		return restauranteRepositorio.save(atualizar);
	}
	
	public void excluirRestaurante(Long id) {
		restauranteRepositorio.deleteById(id);
	}
}
