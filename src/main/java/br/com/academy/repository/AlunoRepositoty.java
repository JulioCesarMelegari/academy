package br.com.academy.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.academy.entity.Aluno;

@Repository
public interface AlunoRepositoty extends JpaRepository<Aluno, Long> {

}
