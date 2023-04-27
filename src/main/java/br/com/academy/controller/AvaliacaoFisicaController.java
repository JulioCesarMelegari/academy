package br.com.academy.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.academy.entity.AvaliacaoFisica;
import br.com.academy.entity.form.AvaliacaoFisicaForm;
import br.com.academy.service.impl.AvaliacaoFisicaServiceImpl;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {
	
	private AvaliacaoFisicaServiceImpl service;
	
	@GetMapping
	public List<AvaliacaoFisica> getAll(){
		return service.getAll();
	}
	
	@PostMapping
	public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm form) {
		return service.create(form);
	}

}
