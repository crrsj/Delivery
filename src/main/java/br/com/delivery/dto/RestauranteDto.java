package br.com.delivery.dto;

import java.util.List;

import br.com.delivery.entidade.Produto;
import br.com.delivery.entidade.Restaurante;
import br.com.delivery.enums.StatusFuncionamento;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RestauranteDto {

	private Long id;
	@NotBlank(message = "não pode estar em branco !")
	private String nomeFantasia;
	private String descricao;	
	private StatusFuncionamento status;
	private List<Produto>produto;
	
	public RestauranteDto(Restaurante restaurante) {
		
		this.id = restaurante.getId();
		this.nomeFantasia = restaurante.getNomeFantasia();
		this.descricao = restaurante.getDescricao();
		this.status = restaurante.getStatus();
		this.produto = restaurante.getProduto();
	}
}
