package br.com.delivery.dto;

import java.util.Date;

import br.com.delivery.entidade.Cliente;
import br.com.delivery.entidade.Endereco;
import br.com.delivery.entidade.Pedido;
import br.com.delivery.enums.StatusPedido;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class PedidoDto {
	private Long id;	
	private Date dataCriacao;
	private Date dataAtualizacao;	
	private StatusPedido status;
	private Cliente cliente;	
	private Endereco endereco;	
	
	public PedidoDto(Pedido pedido) {
		this.id = pedido.getId();
		this.dataCriacao = pedido.getDataCriacao();
		this.dataAtualizacao = pedido.getDataAtualizacao();
		this.status = pedido.getStatus();
		this.cliente  =pedido.getCliente();
		this.endereco = pedido.getEndereco();
	}

}
