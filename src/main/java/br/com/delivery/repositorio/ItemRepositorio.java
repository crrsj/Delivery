package br.com.delivery.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.delivery.entidade.Item;

public interface ItemRepositorio extends JpaRepository<Item, Long> {

}
