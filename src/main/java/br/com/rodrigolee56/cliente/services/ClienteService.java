package br.com.rodrigolee56.cliente.services;

import br.com.rodrigolee56.cliente.controllers.dto.filtro.Clientefiltro;
import br.com.rodrigolee56.cliente.entities.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ClienteService {
    Cliente salvar(Cliente cliente);

    Page<Cliente> listaCliente(Clientefiltro clientefiltro, Pageable pageable);

    Optional<Cliente> buscarPorId(Long id);

    void removePorId(Long id);
}
