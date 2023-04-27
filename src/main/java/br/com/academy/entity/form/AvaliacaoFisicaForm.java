package br.com.academy.entity.form;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaForm {
	
	@Positive(message = "O id do aluno precisa ser positivo")
	private Long alunoId;
	
	@NotNull(message = "Preencha o campo corretamente")
	@Positive(message = "O id do aluno precisa ser positivo")
	private double peso;
	
	@NotNull(message = "Preencha o campo corretamente")
	@Positive(message = "O id do aluno precisa ser positivo")
	@DecimalMin(value = "120", message="'${validatedValue}' precisa ser no minimo {value}.")
	private double altura;
}
