package br.com.delivery.servico;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.delivery.dto.AtualizarDto;
import br.com.delivery.dto.BuscarClienteDto;
import br.com.delivery.dto.ClienteDtO;
import br.com.delivery.entidade.Cliente;
import br.com.delivery.repositorio.ClienteRepositorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServico {
	
	private final ClienteRepositorio clienteRepositorio;
	

	public Cliente cadastrarCliente(ClienteDtO clienteDto) {
		var cadastrar = new Cliente(clienteDto);
		cadastrar.setDataCriacao(new Date());
		return clienteRepositorio.save(cadastrar);
	}
	
	public List<BuscarClienteDto>buscarClientes(){
		return clienteRepositorio.findAll().stream().map(BuscarClienteDto::new).toList();		
		
	}
	
	public Cliente buscarPorId(Long id) {
		Optional<Cliente>buscar = clienteRepositorio.findById(id);
		return buscar.get();
	}
	
	public Cliente atualizarCliente(AtualizarDto atualizarDto,Long id) {
		var atualizar = new Cliente(atualizarDto);
		atualizar.setId(id);
		atualizar.setDataAtualizacao(new Date());
		return clienteRepositorio.save(atualizar);
	}
	
	
	public void excluirCliente(Long id) {
		clienteRepositorio.deleteById(id);
	}
	
	public List<Cliente>  buscarPorNome(String nome) {
		return clienteRepositorio.findByNome(nome.trim().toUpperCase());
		
	}
}
