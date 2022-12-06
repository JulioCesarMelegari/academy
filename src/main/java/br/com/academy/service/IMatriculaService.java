package br.com.academy.service;

import java.util.List;

import br.com.academy.entity.Matricula;
import br.com.academy.entity.form.MatriculaForm;

public interface IMatriculaService {
	
	Matricula create(MatriculaForm form);
	Matricula get(Long id);
	List<Matricula> getAll();
	void delet(Long id);

}
