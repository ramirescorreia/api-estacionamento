package br.com.estacionamento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.estacionamento.entidades.Cliente;
import br.com.estacionamento.repositorios.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	private ClienteRepository clienteRepository;
	
	@Autowired
	public ClienteController(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	@PostMapping("/salvar")
	public Cliente cadastraCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@RequestMapping(value="/cpf/{cpf}", method= RequestMethod.GET, produces="application/json", consumes="application/json")
	public ResponseEntity<Cliente> buscaEstacionamentosPeloIdPatio(@PathVariable("cpf") String cpf){
		Cliente cliente = clienteRepository.findClienteByCpf(cpf);
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
}
