package br.com.academy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.academy.entity.Aluno;
import br.com.academy.entity.AvaliacaoFisica;
import br.com.academy.entity.form.AlunoForm;
import br.com.academy.entity.form.AlunoUpdateForm;
import br.com.academy.service.impl.AlunoServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoServiceImpl service;
	
	@GetMapping
	public List<Aluno> getAll(@RequestParam(value="dataDeNascimento", required = false) String dataDeNascimento){
		return service.getAll(dataDeNascimento);
	}
	
	@PostMapping
	public Aluno create(@Valid @RequestBody AlunoForm form) {
		return service.create(form);
	}
	
	@GetMapping("/avaliacoes/{id}")
	public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
		return service.getAllAvaliacaoFisicaId(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		service.delete(id);
	}
	
	@PutMapping("/{id}")
	public Aluno update(@RequestBody Long id, AlunoUpdateForm form) {
		
		return service.update(id, form);
	}
}
