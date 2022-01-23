package com.braian.teste.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.braian.teste.model.Preco;
import com.braian.teste.repository.PrecoRepository;

@Service
public class VeiculoService {

	@Autowired
	private PrecoRepository precoRepository;
	
	
	public Long calcularTempo(String dataEntrada, String dataSaida) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Calendar calInicial = Calendar.getInstance();
        Calendar calFinal = Calendar.getInstance();

        calInicial.setTime(sdf.parse(dataEntrada));
        calFinal.setTime(sdf.parse(dataSaida));

        long minutos = ((calFinal.getTimeInMillis() - calInicial.getTimeInMillis())) / 60000;
        long horas = minutos / 60;
        if (horas < 1) {
        	return 1L;
        }
		return horas;
	}
	
	public Double calcularPreco(Long horas) {
		Preco precos = precoRepository.getById(1L);
		double primeiraHora = precos.getValorPrimeiraHora();
		double horasDemais = precos.getValorDemaisHoras();
		double preco = 0.0;
		if(horas <= 1) {
			preco = primeiraHora;
		}
		else {
			preco = primeiraHora + ((horas - 1) * horasDemais);
		}
		
		return preco;
	}
}
