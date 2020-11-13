package com.br.petz.apirest.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.br.petz.apirest.model.Pet;
import com.br.petz.apirest.model.Sexo;
import com.br.petz.apirest.model.Tamanho;

public class PetDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private Integer idade;
	private Sexo sexo;
	private String raca;
	private Tamanho tamanho;

	public PetDTO(Pet petModel) {
		this.nome = petModel.getNome();
		this.idade = petModel.getIdade();
		this.sexo = petModel.getSexo();
		this.raca = petModel.getRaca();
		this.tamanho = petModel.getTamanho();

	}

	public String getNome() {
		return nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public Sexo getSexo() {
		return sexo;
	}
	public String getRaca() {
		return raca;
	}
	public Tamanho getTamanho() {
		return tamanho;
	}
	
	public static List<PetDTO>converter(List<Pet>pets){
		return pets.stream().map(PetDTO::new).collect(Collectors.toList());
	}

}
