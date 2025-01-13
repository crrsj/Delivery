package br.com.delivery.servico;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.delivery.dto.PedidoDto;
import br.com.delivery.entidade.Pedido;
import br.com.delivery.repositorio.ClienteRepositorio;
import br.com.delivery.repositorio.PedidoRepositorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoServico {
	
	private final PedidoRepositorio pedidoRepositorio;
	private final ClienteRepositorio clienteRepositorio;
	
	public Pedido criarpedido(PedidoDto pedidoDto,Long clienteId) {
		var pedido = new Pedido(pedidoDto);
		var cliente = clienteRepositorio.findById(clienteId).get();
		pedido.setCliente(cliente);
		pedido.setDataCriacao(new Date());
		return pedidoRepositorio.save(pedido);
		
	}

	public List<PedidoDto> buscarPedidos() {
		return pedidoRepositorio.findAll().stream().map(PedidoDto::new).toList();
	}
	
	public Pedido buscarPorId(Long id) {
		Optional<Pedido>buscar = pedidoRepositorio.findById(id);
		return buscar.get();
	}
	
	public Pedido atualizarPedido(PedidoDto pedidoDto,Long id) {
		var atualizar = new Pedido(pedidoDto);
		atualizar.setId(id);
		atualizar.setDataAtualizacao(new Date());
		return pedidoRepositorio.save(atualizar);
	}
	
	public void excluirPedidos(Long id) {
		pedidoRepositorio.deleteById(id);
	}
}
