package br.com.estacionamento.entidades;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Patio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	 
	@Column
	private String descricao;
	    
	@Column
	private Integer numeroVaga;
	 
	@Column
	private Double valorHora;
	
	@OneToMany(targetEntity = Estacionamento.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Estacionamento> estacionamentos;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getNumeroVaga() {
		return numeroVaga;
	}

	public void setNumeroVaga(Integer numeroVaga) {
		this.numeroVaga = numeroVaga;
	}

	public void setValorHora(Double valorHora) {
		this.valorHora = valorHora;
	}
	
	public Double getValorHora() {
		return this.valorHora;
	}
}
