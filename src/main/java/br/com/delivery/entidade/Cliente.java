package br.com.delivery.entidade;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.delivery.dto.AtualizarDto;
import br.com.delivery.dto.ClienteDtO;
import br.com.delivery.enums.Tipo;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_clientes")
@Data
@NoArgsConstructor
public class Cliente {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String fone;
	private String email;	
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	@Temporal(TemporalType.TIME)
	private Date dataCriacao;
	@Temporal(TemporalType.TIME)
	private Date dataAtualizacao;
	@JsonIgnore
	@OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Pedido>pedido;
	@JsonIgnore
	@OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Endereco>endereco;

	public Cliente(AtualizarDto atualizarDto) {
	  this.nome = atualizarDto.getNome();
	  this.fone = atualizarDto.getFone();
	  this.email = atualizarDto.getEmail();	 
	  this.dataCriacao = atualizarDto.getDataCriacao();
	  this.dataAtualizacao = atualizarDto.getDataAtualizacao();
	}

	public Cliente(ClienteDtO clienteDto) {
		this.nome = clienteDto.getNome();
		this.fone = clienteDto.getFone();
		this.email = clienteDto.getEmail();		
		this.tipo = clienteDto.getTipo();
		this.dataCriacao = clienteDto.getDataCriacao();
		this.dataAtualizacao = clienteDto.getDataAtualizacao();
	}
}
