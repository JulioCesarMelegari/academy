package br.com.academy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academy.entity.Aluno;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Aluno get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aluno> getAll() {
		return repository.findAll();
	}

	@Override
	public Aluno update(Long id, AlunoUpdateForm formUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
