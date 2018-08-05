package br.com.estacionamento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.estacionamento.entidades.Estacionamento;
import br.com.estacionamento.repositorios.EstacionamentoRepository;

@RestController
@RequestMapping("/estacionamentos")
public class EstacionamentoController {
	
	@Autowired
	private EstacionamentoRepository estacionamentoRepository;
	
	@RequestMapping(value="/patio/{idPatio}", method= RequestMethod.GET, produces="application/json", consumes="application/json")
	public ResponseEntity<List<Estacionamento>> buscaEstacionamentosPeloIdPatio(@PathVariable("idPatio") Long idPatio){
		List<Estacionamento> estacionamentos = estacionamentoRepository.findAllByIdPatio(idPatio);
		return new ResponseEntity<>(estacionamentos, HttpStatus.OK);
	}
	
	@PostMapping("/salvar")
	public void cadastraCliente(@RequestBody Estacionamento estacionamento) {
		 estacionamentoRepository.save(estacionamento);
	}
	
	@RequestMapping(value="/find/{idEstacionamento}", method= RequestMethod.GET, produces="application/json", consumes="application/json")
	public ResponseEntity<Estacionamento> buscaEstacionamento(@PathVariable("idEstacionamento") Long idEstacionamento){
		Estacionamento estacionamento = estacionamentoRepository.getOne(idEstacionamento);
		return new ResponseEntity<>(estacionamento, HttpStatus.OK);
	}
	
}
