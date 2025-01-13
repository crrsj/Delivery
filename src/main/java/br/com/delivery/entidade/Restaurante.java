package br.com.delivery.entidade;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.delivery.dto.RestauranteDto;
import br.com.delivery.enums.StatusFuncionamento;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_restaurantes")
@Data
@NoArgsConstructor
public class Restaurante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeFantasia;
	private String descricao;
	@Enumerated(EnumType.STRING)
	private StatusFuncionamento status;
	@JsonIgnore
	@OneToMany(mappedBy = "restaurante",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Produto>produto;
	

	public Restaurante(RestauranteDto restauranteDto) {
		this.id = restauranteDto.getId();
		this.nomeFantasia  =restauranteDto.getNomeFantasia();
		this.descricao = restauranteDto.getDescricao();
		this.status = restauranteDto.getStatus();
	}
}
