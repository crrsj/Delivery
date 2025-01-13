package br.com.delivery.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.delivery.entidade.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {

}
