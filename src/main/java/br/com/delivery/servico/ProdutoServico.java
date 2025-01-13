package br.com.delivery.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.delivery.dto.ProdutoDto;
import br.com.delivery.entidade.Produto;
import br.com.delivery.repositorio.ProdutoRepositorio;
import br.com.delivery.repositorio.RestauranteRepositorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoServico {

	private final RestauranteRepositorio restauranteRepositorio;
	private final ProdutoRepositorio produtoRepositorio;
	
	public Produto cadastrarProduto(ProdutoDto produtoDto,Long restauranteId) {
		var produto = new Produto(produtoDto);
		var restaurante  = restauranteRepositorio.findById(restauranteId).get();
		produto.setRestaurante(restaurante);
		return produtoRepositorio.save(produto);
	}
	
	public List<ProdutoDto>buscarProdutos(){
		return produtoRepositorio.findAll().stream().map(ProdutoDto::new).toList();
				
	}
	
	public Produto buscarPorId(Long id) {
		Optional<Produto>buscar = produtoRepositorio.findById(id);
		return buscar.get();
	}
	
	public Produto atualizarProdutos(ProdutoDto produtoDto,Long id) {
		var atualizar = new Produto(produtoDto);
		atualizar.setId(id);
		return produtoRepositorio.save(atualizar);
	}
	
	public void excluirProduto(Long id) {
		produtoRepositorio.deleteById(id);
	}
	
	
}
