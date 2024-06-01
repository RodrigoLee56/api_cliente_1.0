package br.com.rodrigolee56.cliente.services.impl;

import br.com.rodrigolee56.cliente.controllers.dto.filtro.Clientefiltro;
import br.com.rodrigolee56.cliente.entities.Cliente;
import br.com.rodrigolee56.cliente.repositories.ClienteRepository;
import br.com.rodrigolee56.cliente.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Page<Cliente> listaCliente(Clientefiltro clientefiltro, Pageable pageable) {
        Cliente cliente = Cliente.builder()
                .id(clientefiltro.getId())
                .nome(clientefiltro.getNome())
                .email(clientefiltro.getEmail())
                .cpf(clientefiltro.getCpf())
                .build();

        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Cliente> example = Example.of(cliente, exampleMatcher);

        return clienteRepository.findAll(example, pageable);
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public void removePorId(Long id) {
        clienteRepository.deleteById(id);
    }
}
