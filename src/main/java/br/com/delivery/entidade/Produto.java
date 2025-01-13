package br.com.delivery.entidade;

import br.com.delivery.dto.ProdutoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_produtos")
@Data
@NoArgsConstructor
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private Double preco;
	@ManyToOne
	@JoinColumn(name = "restaurante_Id")
	private Restaurante restaurante;	
	
	public Produto(ProdutoDto produtoDto) {
		this.id = produtoDto.getId();
		this.nome = produtoDto.getNome();
		this.descricao = produtoDto.getDescricao();
		this.preco = produtoDto.getPreco();
		this.restaurante = produtoDto.getRestaurante();
	}
	

}
