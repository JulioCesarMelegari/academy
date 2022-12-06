package br.com.academy.service;

import java.util.List;

import br.com.academy.entity.Aluno;
import br.com.academy.entity.form.AlunoForm;
import br.com.academy.entity.form.AlunoUpdateForm;

public interface IAlunoService {
	
	Aluno create(AlunoForm form);
	Aluno get(Long id);
	List<Aluno> getAll();
	Aluno update(Long id, AlunoUpdateForm formUpdate);
	void delete(Long id);

}
