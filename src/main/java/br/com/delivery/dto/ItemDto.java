package br.com.delivery.dto;

import java.util.Date;

import br.com.delivery.entidade.Item;
import br.com.delivery.entidade.Pedido;
import br.com.delivery.entidade.Produto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemDto {
	private Long id;	
	private Date dataCriacao;	
	private Date dataAtualizacao;
	private Integer quantidade;
	private Double precoUnitario;
	private Produto produto;	
	private Pedido pedido;
	
	public ItemDto(Item item) {
		this.id = item.getId();
		this.dataCriacao = item.getDataCriacao();
		this.dataAtualizacao = item.getDataAtualizacao();
		this.quantidade = item.getQuantidade();
		this.precoUnitario = item.getPrecoUnitario();
		this.produto = item.getProduto();
		this.pedido = item.getPedido();
	}
}
