package br.com.delivery.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.delivery.entidade.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

	@Query(value = "select c from Cliente c where upper(trim(c.nome)) like %?1% ") 
	List<Cliente> findByNome(String nome);

}
