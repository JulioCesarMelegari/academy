package br.com.academy.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academy.entity.Aluno;
import br.com.academy.entity.AvaliacaoFisica;
import br.com.academy.entity.form.AlunoForm;
import br.com.academy.entity.form.AlunoUpdateForm;
import br.com.academy.repository.AlunoRepositoty;
import br.com.academy.service.IAlunoService;

@Service
public class AlunoServiceImpl implements IAlunoService {
	
	@Autowired
	private AlunoRepositoty repository;
	
	@Override
	public Aluno create(AlunoForm form) {
		Aluno aluno = new Aluno();
		aluno.setNome(form.getNome());
		aluno.setCpf(form.getCpf());
		aluno.setBairro(form.getBairro());
		aluno.setDataNascimento(form.getDataNascimento());
		return repository.save(aluno);
	}

	@Override
	public Aluno get(Long id){
		return repository.findById(id).get();
	}

	@Override
	public List<Aluno> getAll(String dataDeNascimento) {
		if(dataDeNascimento == null) {
			return repository.findAll();
		}else {
			LocalDate localDate = LocalDate.parse(dataDeNascimento, DateTimeFormatter.ISO_LOCAL_DATE);
			return repository.findByDataNascimento(localDate);
		}		
	}

	@Override
	public Aluno update(Long id, AlunoUpdateForm formUpdate) {
		Aluno aluno = repository.findById(id).get();
		aluno.setNome(formUpdate.getNome());
		aluno.setBairro(formUpdate.getBairro());
		aluno.setDataNascimento(formUpdate.getDatanascimento());
		return repository.save(aluno);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);	
	}
	
	public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id){
		Aluno aluno = repository.findById(id).get();
		return aluno.getAvaliacoes();
	}

}
