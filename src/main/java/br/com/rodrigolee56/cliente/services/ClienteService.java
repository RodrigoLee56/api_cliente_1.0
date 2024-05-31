package br.com.rodrigolee56.cliente.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rodrigolee56.cliente.entities.Cliente;
import br.com.rodrigolee56.cliente.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> listaCliente() {
		return clienteRepository.findAll();
	}
	
	public Optional<Cliente> buscarPorId(Long id) {
		return clienteRepository.findById(id);
	}
	
	public void removePorId(Long id) {
		clienteRepository.deleteById(id);
	}
}
