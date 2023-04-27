package br.com.academy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academy.entity.Aluno;
import br.com.academy.entity.AvaliacaoFisica;
import br.com.academy.entity.form.AvaliacaoFisicaForm;
import br.com.academy.entity.form.AvaliacaoFisicaUpdateForm;
import br.com.academy.repository.AlunoRepositoty;
import br.com.academy.repository.AvaliacaoFisicaRepository;
import br.com.academy.service.IAvaliacaoFisicaService;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService{
	
	@Autowired
	private AvaliacaoFisicaRepository avaliacaoRepository;
	
	@Autowired
	private AlunoRepositoty alunoRepository;
	
	@Override
	public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
		AvaliacaoFisica avaliacao = new AvaliacaoFisica();
		Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();
		
		avaliacao.setAluno(aluno);
		avaliacao.setPeso(form.getPeso());
		avaliacao.setAltura(form.getAltura());
		
		return avaliacaoRepository.save(avaliacao);
	}

	@Override
	public AvaliacaoFisica get(Long id) {
		return avaliacaoRepository.findById(id).get();
	}

	@Override
	public List<AvaliacaoFisica> getAll() {
		avaliacaoRepository.findAll();
		return null;
	}

	@Override
	public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		avaliacaoRepository.deleteById(id);	
	}

}
