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

import br.com.estacionamento.entidades.Veiculo;
import br.com.estacionamento.repositorios.VeiculoRepository;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
	
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	public VeiculoController(VeiculoRepository veiculoRepository) {
		this.veiculoRepository = veiculoRepository;
	}
	
	@RequestMapping(value="/placa/{placa}", method= RequestMethod.GET, produces="application/json", consumes="application/json")
	public ResponseEntity<Veiculo> buscaEstacionamentosPeloIdPatio(@PathVariable("placa") String placa){
		Veiculo veiculo = veiculoRepository.findByPlaca(placa);
		return new ResponseEntity<>(veiculo, HttpStatus.OK);
	}
	
	@PostMapping("/salvar")
	public void cadastraVeiculo(@RequestBody Veiculo veiculo) {
		this.veiculoRepository.save(veiculo);
	}
}
