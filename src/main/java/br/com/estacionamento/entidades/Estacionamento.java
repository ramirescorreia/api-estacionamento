package br.com.estacionamento.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.estacionamento.enuns.Vaga;

@Entity
public class Estacionamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private Date horaEntrada;
	
	@Column
	private Date horaSaida;
	
	@Column
	private String tempoPermanencia;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Vaga statusVaga;
	
	@Column
	private Double valorCobrado;
	
	@ManyToOne
	@JoinColumn(name="patio_FK")
	private Patio patio;
	
	@OneToOne
	@JoinColumn(name="veiculo_FK")
	private Veiculo veiculo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public Date getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(Date horaSaida) {
		this.horaSaida = horaSaida;
	}

	public String getTempoPermanencia() {
		return tempoPermanencia;
	}

	public void setTempoPermanencia(String tempoPermanencia) {
		this.tempoPermanencia = tempoPermanencia;
	}

	public Double getValorCobrado() {
		return valorCobrado;
	}

	public void setValorCobrado(Double valorCobrado) {
		this.valorCobrado = valorCobrado;
	}

	public Patio getPatio() {
		return patio;
	}

	public void setPatio(Patio patio) {
		this.patio = patio;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Vaga getStatusVaga() {
		return statusVaga;
	}

	public void setStatusVaga(Vaga statusVaga) {
		this.statusVaga = statusVaga;
	}
}
