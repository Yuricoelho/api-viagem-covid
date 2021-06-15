package com.viagem.api.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Double qtdHabitantes;
	private Double qtdVacinados;

	@ManyToOne
	@JoinColumn(name = "cidade_id")
	private Estado estado;

	public Cidade() {

	}

	public Cidade(Long id, String nome, Double qtdHabitantes, Double qtdVacinados, Estado estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.qtdHabitantes = qtdHabitantes;
		this.qtdVacinados = qtdVacinados;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getQtdHabitantes() {
		return qtdHabitantes;
	}

	public void setQtdHabitantes(Double qtdHabitantes) {
		this.qtdHabitantes = qtdHabitantes;
	}

	public Double getQtdVacinados() {
		return qtdVacinados;
	}

	public void setQtdVacinados(Double qtdVacinados) {
		this.qtdVacinados = qtdVacinados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String vacinados() {

		Double total = (qtdVacinados / 100) * qtdHabitantes;
		 
		 return "A população total dessa cidade é: " + qtdHabitantes + " E a quantidade de VACINADOS é: " + total
				 + "\n" + ValorFinal();

	}

	public String ValorFinal() {

		String  TotalVacinados = null;

		if (qtdVacinados <= 33.00) {
			
			TotalVacinados = "Área de risco! Recomenda-se que, pelo menos, metade da população esteja vacinada";

		} else if(qtdVacinados > 33.00 && qtdVacinados <= 69.99) {
			TotalVacinados ="Área Moderada! Faça sua reserva e mantenha os cuidados";

		} else {
			TotalVacinados = "Mais da metade da População está vacinada! ";

		}

		return TotalVacinados;
	}
}
