package br.com.delivery.servico;

import org.springframework.stereotype.Service;

import br.com.delivery.dto.EnderecoDto;
import br.com.delivery.entidade.Endereco;
import br.com.delivery.repositorio.ClienteRepositorio;
import br.com.delivery.repositorio.EnderecoRepositorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnderecoServico {

	private final ClienteRepositorio clienteRepositorio;
	private final EnderecoRepositorio enderecoRepositorio;
	
	
	public Endereco cadastrarEndereco(EnderecoDto enderecoDto,Long clienteId) {
		var cadastrar = new Endereco(enderecoDto);
		var cliente = clienteRepositorio.findById(clienteId).get();
		cadastrar.setCliente(cliente);
		return enderecoRepositorio.save(cadastrar);
	}
	
	public Endereco atualizarEndereco(EnderecoDto enderecoDto,Long id) {
		var atualizar = new Endereco(enderecoDto);
		atualizar.setId(id);
		return enderecoRepositorio.save(atualizar);
	}
	
}
