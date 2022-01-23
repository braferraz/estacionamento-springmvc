package com.braian.teste.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "tbl_valor")
@Table
public class Preco {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double valorPrimeiraHora;
	private double valorDemaisHoras;
	
	public Preco() {
	}

	public Preco(Long id, double valorPrimeiraHora, double valorDemaisHoras) {
		super();
		this.id = id;
		this.valorPrimeiraHora = valorPrimeiraHora;
		this.valorDemaisHoras = valorDemaisHoras;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValorPrimeiraHora() {
		return valorPrimeiraHora;
	}

	public void setValorPrimeiraHora(double valorPrimeiraHora) {
		this.valorPrimeiraHora = valorPrimeiraHora;
	}

	public double getValorDemaisHoras() {
		return valorDemaisHoras;
	}

	public void setValorDemaisHoras(double valorDemaisHoras) {
		this.valorDemaisHoras = valorDemaisHoras;
	}

}
