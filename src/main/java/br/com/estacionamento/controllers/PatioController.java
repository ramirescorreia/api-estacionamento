package br.com.estacionamento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.estacionamento.entidades.Patio;
import br.com.estacionamento.repositorios.PatioRepository;

@RestController
@RequestMapping("/patio")
public class PatioController {

	private PatioRepository patioRepository;
	
	@Autowired
	public PatioController(PatioRepository patioRepository) {
		this.patioRepository = patioRepository;
	}
	
	@PostMapping("/salvar")
	public void cadastraPatio(@RequestBody Patio patio) {
		patioRepository.save(patio);
	}
	
	@RequestMapping(value="/busca/{descricao}", method= RequestMethod.GET, produces="application/json", consumes="application/json")
	public ResponseEntity<List<Patio>> buscaPatiosPelaDescricao(@PathVariable("descricao") String descricao){
		List<Patio> patios = patioRepository.findByDescricaoContaining(descricao);
		return new ResponseEntity<>(patios, HttpStatus.OK);
	}
	
	@GetMapping("/todos")
	public ResponseEntity<List<Patio>> buscaTodosPatios(){
		List<Patio> patios = patioRepository.findAll();
		return new ResponseEntity<>(patios, HttpStatus.OK);
	}
}
