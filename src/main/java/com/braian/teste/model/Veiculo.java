package com.braian.teste.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Builder;

@Entity(name = "tbl_movimentacao")
@Builder
public class Veiculo {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message ="Campo não pode ser nulo")
	@NotEmpty(message ="Campo não pode ser vazio")
	@Size(min=7, max=8, message="Campo deve conter entre 7 e 8 caracteres")
	private String placa;

	@NotNull(message ="Campo não pode ser nulo")
	@NotBlank(message ="Campo não pode ser nulo ou vazio")
	@Size(min = 2, max = 30, message="Campo deve conter entre 2 e 30 caracteres")
	private String modelo;
	
	private String dataEntrada;
	private String dataSaida;
	private String tempo;
	private double valorPago; 
	
	public Veiculo() {}

	public Veiculo(Long id, String placa, String modelo, String dataEntrada, String dataSaida, String tempo,
			double valorPago) {
		super();
		this.id = id;
		this.placa = placa;
		this.modelo = modelo;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.tempo = tempo;
		this.valorPago = valorPago;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public String getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataEntrada == null) ? 0 : dataEntrada.hashCode());
		result = prime * result + ((dataSaida == null) ? 0 : dataSaida.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		result = prime * result + ((tempo == null) ? 0 : tempo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorPago);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (dataEntrada == null) {
			if (other.dataEntrada != null)
				return false;
		} else if (!dataEntrada.equals(other.dataEntrada))
			return false;
		if (dataSaida == null) {
			if (other.dataSaida != null)
				return false;
		} else if (!dataSaida.equals(other.dataSaida))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		if (tempo == null) {
			if (other.tempo != null)
				return false;
		} else if (!tempo.equals(other.tempo))
			return false;
		if (Double.doubleToLongBits(valorPago) != Double.doubleToLongBits(other.valorPago))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", placa=" + placa + ", modelo=" + modelo + ", dataEntrada=" + dataEntrada
				+ ", dataSaida=" + dataSaida + ", tempo=" + tempo + ", valorPago=" + valorPago + "]";
	}
	
}
