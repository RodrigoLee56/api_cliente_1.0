package br.com.rodrigolee56.cliente.controllers;

import br.com.rodrigolee56.cliente.controllers.dto.filtro.Clientefiltro;
import br.com.rodrigolee56.cliente.entities.Cliente;
import br.com.rodrigolee56.cliente.services.impl.ClienteServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteServiceImpl clienteServiceImpl;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody Cliente cliente){
        return clienteServiceImpl.salvar(cliente);
    }

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Page<Cliente> listaCliente(Clientefiltro clientefiltro, Pageable pageable) {
		return clienteServiceImpl.listaCliente(clientefiltro, pageable);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Cliente buscarPorId(@PathVariable("id") Long id) {
		return clienteServiceImpl.buscarPorId(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeCliente(@PathVariable("id") Long id) {
		clienteServiceImpl.buscarPorId(id).map(cliente -> {
			clienteServiceImpl.removePorId(id);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
		clienteServiceImpl.buscarPorId(id).map(cliented -> {
			modelMapper.map(cliente, cliented);
			clienteServiceImpl.salvar(cliented);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
	}
}
