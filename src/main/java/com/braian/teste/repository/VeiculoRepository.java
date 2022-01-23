package com.braian.teste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.braian.teste.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	@Query("SELECT a FROM tbl_movimentacao a WHERE valor_pago = 0.00")
	public List<Veiculo> buscarVeiculos(); 
	
	@Query("SELECT b FROM tbl_movimentacao b WHERE valor_pago > 0.00 ORDER BY data_saida ASC")
	public List<Veiculo> buscarSaida();
}
