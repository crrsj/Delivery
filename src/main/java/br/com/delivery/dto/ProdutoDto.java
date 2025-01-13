package br.com.delivery.dto;

import br.com.delivery.entidade.Produto;
import br.com.delivery.entidade.Restaurante;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProdutoDto {
	private Long id;
	@NotBlank(message = "não pode estar em branco !")
	private String nome;
	private String descricao;
	private Double preco;
	private Restaurante restaurante;
	
	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.preco = produto.getPreco();
		this.restaurante = produto.getRestaurante();
	}
}
