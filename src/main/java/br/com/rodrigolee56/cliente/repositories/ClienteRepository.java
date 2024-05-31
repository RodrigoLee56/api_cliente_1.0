package br.com.rodrigolee56.cliente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rodrigolee56.cliente.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
}
