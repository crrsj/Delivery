package br.com.delivery.entidade;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.delivery.dto.PedidoDto;
import br.com.delivery.enums.StatusPedido;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "tb_pedidos")
@Data
@NoArgsConstructor
public class Pedido {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.TIME)
	private Date dataCriacao;
	@Temporal(TemporalType.TIME)
	private Date dataAtualizacao;
	@Enumerated(EnumType.STRING)
	private StatusPedido status;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "cliente_Id")			
	private Cliente cliente;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "endereco_Id")		
	private Endereco endereco;	

	public Pedido(PedidoDto pedidoDto) {
		this.id = pedidoDto.getId();
		this.dataCriacao = pedidoDto.getDataCriacao();
		this.dataAtualizacao = pedidoDto.getDataAtualizacao();
		this.status = pedidoDto.getStatus();
		this.cliente = pedidoDto.getCliente();
		this.endereco = pedidoDto.getEndereco();
	}
}
