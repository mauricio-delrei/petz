package com.br.petz.apirest.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.br.petz.apirest.model.Cliente;
import com.br.petz.apirest.model.Sexo;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private Integer idade;
	private Sexo sexo;
	private String email;
	private String telefone;

	public ClienteDTO(Cliente clienteModel) {
		this.nome = clienteModel.getNome();
		this.idade = clienteModel.getIdade();
		this.sexo = clienteModel.getSexo();
		this.email = clienteModel.getEmail();
		this.telefone = clienteModel.getTelefone();

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
	public String getEmail() {
		return email;
	}
	public String getTelefone() {
		return telefone;
	}
	
	public static List<ClienteDTO>converter(List<Cliente>clientes){
		return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
	}

}
