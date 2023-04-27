package br.com.academy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.academy.entity.Matricula;
import br.com.academy.entity.form.MatriculaForm;
import br.com.academy.repository.MatriculaRepository;
import br.com.academy.service.IMatriculaService;

public class MatriculaServiceImpl implements IMatriculaService{
	
	@Autowired
	private MatriculaRepository matriculaRepository;

	@Override
	public Matricula create(MatriculaForm form) {
	
		return null;
	}

	@Override
	public Matricula get(Long id) {
		return matriculaRepository.findById(id).get();
	}

	@Override
	public List<Matricula> getAll(String bairro) {
		if(bairro == null) {
			return matriculaRepository.findAll();
		}else {
			return matriculaRepository.findByAlunoBairro(bairro);
		}
	}

	@Override
	public void delet(Long id) {
		matriculaRepository.deleteById(id);	
	}

}
