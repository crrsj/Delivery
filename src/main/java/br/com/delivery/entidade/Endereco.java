package br.com.delivery.entidade;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.delivery.dto.EnderecoDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_enderecos")
@Data
@NoArgsConstructor
public class Endereco {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String rua;
	private String bairro;
	private String numero;
	private String complemento;
	private String cidade;
	private String estado;
	@ManyToOne
	@JoinColumn(name = "cliente_Id")
	private Cliente cliente;
	@OneToMany(mappedBy = "endereco",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnore
	private List<Pedido>pedido;
	
	public Endereco(EnderecoDto enderecoDto) {
		this.id = enderecoDto.getId();
		this.rua = enderecoDto.getRua();
		this.bairro = enderecoDto.getBairro();
		this.numero = enderecoDto.getNumero();
		this.complemento = enderecoDto.getComplemento();
		this.cidade = enderecoDto.getCidade();
		this.estado = enderecoDto.getEstado();
		this.cliente = enderecoDto.getCliente();
		this.pedido = enderecoDto.getPedido();
	}

}
