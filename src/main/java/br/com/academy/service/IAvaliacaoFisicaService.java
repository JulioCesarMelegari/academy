package br.com.academy.service;

import java.util.List;

import br.com.academy.entity.AvaliacaoFisica;
import br.com.academy.entity.form.AvaliacaoFisicaForm;
import br.com.academy.entity.form.AvaliacaoFisicaUpdateForm;

public interface IAvaliacaoFisicaService {
	
	AvaliacaoFisica create(AvaliacaoFisicaForm form);
	AvaliacaoFisica get(Long id);
	List<AvaliacaoFisica> getAll();
	AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate);
	void delete(Long id);

}
