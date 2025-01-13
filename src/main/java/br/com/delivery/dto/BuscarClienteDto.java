package br.com.delivery.dto;

import java.util.Date;
import java.util.List;

import br.com.delivery.entidade.Cliente;
import br.com.delivery.entidade.Endereco;
import br.com.delivery.entidade.Pedido;
import br.com.delivery.enums.Tipo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BuscarClienteDto {
    
	private Long id;
	private String nome;
	private String fone;
	private String email;
	private Tipo tipo;	
	private Date dataCriacao;	
	private Date dataAtualizacao;
	private List<Pedido>pedido;	
	private List<Endereco>endereco;
	
	public BuscarClienteDto(Cliente cliente) {
		
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.fone = cliente.getFone();
		this.email = cliente.getEmail();
		this.tipo = cliente.getTipo();
		this.dataCriacao = cliente.getDataCriacao();
		this.dataAtualizacao = cliente.getDataAtualizacao();
		this.pedido = cliente.getPedido();
		this.endereco = cliente.getEndereco();
	}
}
