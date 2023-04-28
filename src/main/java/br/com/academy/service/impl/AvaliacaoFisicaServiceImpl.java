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
		double peso = form.getPeso();
		double altura = form.getAltura();
		double imc = calcImc(form.getPeso(), form.getAltura());
		String classificacao = classificacao(imc);
		
		avaliacao.setAluno(aluno);
		avaliacao.setPeso(peso);
		avaliacao.setAltura(altura);
		avaliacao.setImc(imc);
		avaliacao.setClassificacao(classificacao);
		return avaliacaoRepository.save(avaliacao);
	}

	@Override
	public AvaliacaoFisica get(Long id) {
		return avaliacaoRepository.findById(id).get();
	}

	@Override
	public List<AvaliacaoFisica> getAll() {
		return avaliacaoRepository.findAll();	
	}

	@Override
	public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
		double peso = formUpdate.getPeso();
		double altura = formUpdate.getAltura();
		double imc = calcImc(formUpdate.getPeso(), formUpdate.getAltura());
		String classificacao = classificacao(imc);
		
		AvaliacaoFisica avaliacao = avaliacaoRepository.findById(id).get();
		
		avaliacao.setAltura(altura);
		avaliacao.setPeso(peso);
		avaliacao.setImc(imc);
		avaliacao.setClassificacao(classificacao);
		return avaliacaoRepository.save(avaliacao);
	}

	@Override
	public void delete(Long id) {
		avaliacaoRepository.deleteById(id);	
	}
	
	private double calcImc(double altura, double peso) {
		double imc = peso/(altura * altura);
		return imc;
	}
	
	private String classificacao(double imc) {
		String classificacao = null;
		
		if(imc < 18.5){
			classificacao = "Abaixo do Peso";
		}else {
			if(imc > 40) {
			classificacao = "Obesidade Mórbida";
		}else {
			if( imc < 24.9 && 18.5 < imc) {
			 classificacao = "Peso normal";
		}else{
			if(25.0 < imc && imc < 29.9){
				classificacao = "Sobrepeso";
		}else {
			if(30.0 < imc && imc < 34.9) {
				classificacao = "Obesidade Grau I";
		}else {
			if(35.0 < imc && imc < 39.9) {
				classificacao = "Obesidade Grau II";
		}
		}}}}}
	 
		return classificacao;
	}

}
