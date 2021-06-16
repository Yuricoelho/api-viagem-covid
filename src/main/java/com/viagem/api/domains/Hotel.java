package com.viagem.api.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer qtdQuartos;
	private Double ocupacao;

	@ManyToOne
	@JoinColumn(name = "cidade_id")
	private Cidade cidade;

	public Hotel() {

	}

	public Hotel(Long id, String nome, Integer qtdQuartos, Double ocupacao, Cidade cidade) {
		this.id = id;
		this.nome = nome;
		this.qtdQuartos = qtdQuartos;
		this.ocupacao = ocupacao;
		this.cidade = cidade;
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

	public Integer getQtdQuartos() {
		return qtdQuartos;
	}

	public void setQtdQuartos(Integer qtdQuartos) {
		this.qtdQuartos = qtdQuartos;
	}

	public Double getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(Double ocupacao) {
		this.ocupacao = ocupacao;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
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
		Hotel other = (Hotel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String TotalOcupacao() {

		String totalOcupados = null;

		if (ocupacao <= 33.00) {

			totalOcupados = "Quantidade de quartos no hotel: " + qtdQuartos + "\n"
					+ "Quantidade de Quartos Disponíveis para reserva: "
					+ (int) (qtdQuartos - ((ocupacao / 100) * qtdQuartos)) + "\n" + "Hotel com ocupação de " + ocupacao
					+ "%" + " Agende sua reserva e mantenha os Cuidados!";

		} else if (ocupacao > 33.00 && ocupacao < 69.99) {

			totalOcupados = "Quantidade de quartos no hotel: " + qtdQuartos + "\n"
					+ "Quantidade de Quartos Disponíveis para reserva: "
					+ (int) (qtdQuartos - ((ocupacao / 100) * qtdQuartos)) + "\n" + "Hotel com ocupação de " + ocupacao
					+ "%" + " da capacidade ocupada, Fica a seu critério agendar a hospedagem, ou aguardar diminuir!";

		} else {

			totalOcupados = "Quantidade de quartos no hotel: " + qtdQuartos + "\n"
					+ "Quantidade de Quartos Disponíveis para reserva: "
					+ (int) (qtdQuartos - ((ocupacao / 100) * qtdQuartos)) + "\n" + "Hotel com " + ocupacao + "%"
					+ " Não recomendamos fazer a hospedagem!";
		}

		return totalOcupados;

	}

}
