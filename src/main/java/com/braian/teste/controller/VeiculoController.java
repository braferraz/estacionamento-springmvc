package com.braian.teste.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.braian.teste.model.Veiculo;
import com.braian.teste.repository.VeiculoRepository;
import com.braian.teste.service.VeiculoService;

@Controller
public class VeiculoController {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private VeiculoService veiculoService;
	
	
	
	@GetMapping("/sistema")
	public ModelAndView sistema() {
		ModelAndView mv = new ModelAndView("sistema");
		List<Veiculo> veiculosEst = veiculoRepository.buscarVeiculos();
		mv.addObject("veiculosEst", veiculosEst);
		return mv;
	}
	@GetMapping("/sistema/retirados")
	public ModelAndView frag1() {
		ModelAndView mv = new ModelAndView("/veiculos/frags/retirados");
		List<Veiculo> veiculosFora = veiculoRepository.buscarSaida();
		mv.addObject("veiculosFora", veiculosFora);
		return mv;
	}
	
	@GetMapping("/veiculos/new")
	public ModelAndView formNovoVeiculo(@ModelAttribute("veiculo")  Veiculo veiculo) throws ParseException {
		System.out.println();
		String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
		ModelAndView mv = new ModelAndView("/veiculos/veiculoNew");
		mv.addObject("dataEntrada", timeStamp );
		return mv;
	}
	
	@PostMapping("/veiculos/save")
	public ModelAndView addNovoVeiculo(@Valid Veiculo veiculo, BindingResult bR) throws ParseException {
		if(bR.hasErrors()) {
			return formNovoVeiculo(veiculo);
		}
		System.out.println(veiculo);
		veiculoRepository.save(veiculo);
		ModelAndView mv = new ModelAndView("redirect:/sistema");
		return mv;
		
	}
	
	@GetMapping("/veiculos/edit/{id}")
	public ModelAndView edit(@PathVariable Long id, @Valid Veiculo veiculo, BindingResult bR) {
		Veiculo vec = veiculoRepository.getById(id);	
		ModelAndView mv = new ModelAndView("/veiculos/veiculoEdit");
		mv.addObject("veiculo", vec);
		return mv;
	}
	
	@PostMapping("/veiculos/edit/")
	public ModelAndView salvarAlteracao(@Valid Veiculo veiculo, BindingResult bR) throws ParseException {
		if(bR.hasErrors()) {
			ModelAndView mv = new ModelAndView("/veiculos/veiculoEdit");
			mv.addObject("erro", bR);
			return mv;
		}
			
		System.out.println(veiculo);
		veiculoRepository.save(veiculo);
		ModelAndView mv = new ModelAndView("redirect:/sistema");
		return mv;
		
	}
	
	@GetMapping("/veiculos/saida/{id}")
	public ModelAndView getSaida(@PathVariable Long id) throws ParseException {
		Veiculo vec = veiculoRepository.getById(id);
		String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
		String horas = veiculoService.calcularTempo(vec.getDataEntrada(), timeStamp).toString();
		
		ModelAndView mv = new ModelAndView("/veiculos/veiculoSaida");
		
		double preco = veiculoService.calcularPreco(veiculoService.calcularTempo(vec.getDataEntrada(), timeStamp));
		mv.addObject("veiculo", vec);
		mv.addObject("dataSaida", timeStamp);
		mv.addObject("horas", horas);
		mv.addObject("preco", preco);
		return mv;
	}
	
	@PostMapping("/veiculos/saida/")
	public ModelAndView setSaida( Veiculo veiculo) throws ParseException {
		veiculoRepository.save(veiculo);
		ModelAndView mv = new ModelAndView("redirect:/sistema");
		return mv;
	}
}
