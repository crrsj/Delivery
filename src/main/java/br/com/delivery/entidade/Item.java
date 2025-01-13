package br.com.delivery.entidade;

import java.util.Date;

import br.com.delivery.dto.ItemDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_itens")
@Data
@NoArgsConstructor
public class Item {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.TIME)
	private Date dataCriacao;
	@Temporal(TemporalType.TIME)
	private Date dataAtualizacao;
	private Integer quantidade;
	private Double precoUnitario;
	@ManyToOne
	@JoinColumn(name = "produto_Id")
	private Produto produto;
	@ManyToOne
	@JoinColumn(name = "pedido_Id")
	private Pedido pedido;
	
	
	public Item(ItemDto itemDto) {
		this.id = itemDto.getId();
		this.dataCriacao = itemDto.getDataCriacao();
		this.dataAtualizacao = itemDto.getDataAtualizacao();
		this.quantidade = itemDto.getQuantidade();
		this.precoUnitario = itemDto.getPrecoUnitario();
		this.produto = itemDto.getProduto();
		this.pedido = itemDto.getPedido();
	}
}
