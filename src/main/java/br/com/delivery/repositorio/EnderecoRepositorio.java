package br.com.delivery.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.delivery.entidade.Endereco;

public interface EnderecoRepositorio extends JpaRepository<Endereco, Long>{

}
