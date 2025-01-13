package br.com.delivery.dto;

import java.util.List;

import br.com.delivery.entidade.Cliente;
import br.com.delivery.entidade.Endereco;
import br.com.delivery.entidade.Pedido;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EnderecoDto {

	private Long id;
	@NotBlank(message = "não pode estar em branco !")
	private String rua;
	@NotBlank(message = "não pode estar em branco !")
	private String bairro;	
	private String numero;
	private String complemento;
	@NotBlank(message = "não pode estar em branco !")
	private String cidade;
	private String estado;	
	private Cliente cliente;
	private List<Pedido>pedido;
	
	
	public EnderecoDto(Endereco cadastrar) {
		this.id = cadastrar.getId();
		this.rua = cadastrar.getRua();
		this.bairro = cadastrar.getBairro();
		this.numero = cadastrar.getNumero();
		this.complemento = cadastrar.getComplemento();
		this.cidade = cadastrar.getCidade();
		this.estado = cadastrar.getEstado();
		this.cliente = cadastrar.getCliente();
		this.pedido = cadastrar.getPedido();
	}
}
