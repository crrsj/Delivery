package br.com.delivery.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.delivery.entidade.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long>{

}
