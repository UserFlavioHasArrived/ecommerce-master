package br.com.senai.ecommerce.repository;

import br.com.senai.ecommerce.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
