package com.br.petz.apirest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pet")
public class Pet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome")
	@NotBlank(message = "Campo Obrigatorio")
	@NotNull(message = "Campo Nao Pode Ser Nulo")
	@Size(max = 100)
	private String nome;
	
	@Column(name = "raca")
	@NotBlank(message = "Campo Obrigatorio")
	@NotNull(message = "Campo Nao Pode Ser Nulo")
	@Size(max = 100)
	private String raca;

	@Column(name = "idade")
	@NotBlank(message = "Campo Obrigatorio")
	@NotNull(message = "Campo Nao Pode Ser Nulo")
	@Size(max = 3)
	private Integer idade;
	
	@Column(name = "sexo")
	@NotBlank(message = "Campo Obrigatorio")
	@NotNull(message = "Campo Nao Pode Ser Nulo")
	@Size(max = 7)
	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	@Column(name = "porte")
	@NotBlank(message = "Campo Obrigatorio")
	@NotNull(message = "Campo Nao Pode Ser Nulo")
	@Size(max = 10)
	@Enumerated(EnumType.STRING)
	private Tamanho tamanho;


	

	

	public Pet() {
	}

	public Pet(Long id, String nome, Integer idade,Tamanho tamanho,
			        String raca, Sexo sexo) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.tamanho = tamanho;
		this.raca = raca;
		this.sexo = sexo;		
		
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

	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Tamanho getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}
	public String getRaca() {
		return raca;
	}
	
	public void setRaca(String raca) {
		this.raca = raca;
	}

	public Sexo getSexo() {
		return sexo;
	}
	
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
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
		Pet other = (Pet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
