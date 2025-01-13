package br.com.delivery.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.delivery.entidade.Restaurante;

public interface RestauranteRepositorio extends JpaRepository<Restaurante, Long> {

}
