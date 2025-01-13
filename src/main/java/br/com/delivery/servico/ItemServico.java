package br.com.delivery.servico;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.delivery.dto.ItemDto;
import br.com.delivery.entidade.Item;
import br.com.delivery.repositorio.ItemRepositorio;
import br.com.delivery.repositorio.PedidoRepositorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemServico {

	private final PedidoRepositorio pedidoRepositorio;
	private final ItemRepositorio itemRepositorio;
	
	
	public Item criarItem(ItemDto itemDto,Long pedidoId) {
		var criar = new Item(itemDto);
		var pedido = pedidoRepositorio.findById(pedidoId).get();
		criar.setDataCriacao(new Date());
		criar.setPedido(pedido);
		return itemRepositorio.save(criar);
	}
	
	public List<ItemDto>buscarItens(){
		return itemRepositorio.findAll().stream().map(ItemDto::new).toList();
	}
	
	public Item buscarPorId(Long id) {
		Optional<Item>buscar = itemRepositorio.findById(id);
		return buscar.get();
	}
	
	public Item atualizarItem(ItemDto itemDto,Long id) {
		var atualizar = new Item(itemDto);
		atualizar.setId(id);
		atualizar.setDataAtualizacao(new Date());
		return itemRepositorio.save(atualizar);
	}
	
	public void excluirItem(Long id) {
		itemRepositorio.deleteById(id);
	}
}
