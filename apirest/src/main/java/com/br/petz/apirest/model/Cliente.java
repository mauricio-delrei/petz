package com.br.petz.apirest.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome")
	@NotBlank(message = "Campo Obrigatorio")
	@NotNull(message = "Campo Nao Pode Ser Nulo")
	@Size(max = 100)
	private String nome;

	@Column(name = "idade")
	@NotBlank(message = "Campo Obrigatorio")
	@NotNull(message = "Campo Nao Pode Ser Nulo")
	@Size(max = 3)
	private Integer idade;

	@Column(name = "email")
	@NotBlank(message = "Campo Obrigatorio")
	@NotNull(message = "Campo Nao Pode Ser Nulo")
	@Email
	@Size(max = 255)
	private String email;

	@Column(name = "endereco")
	@NotBlank(message = "Campo Obrigatorio")
	@NotNull(message = "Campo Nao Pode Ser Nulo")
	@Size(max = 100)
	private String endereco;

	@Column(name = "celular")
	@NotBlank(message = "Campo Obrigatorio")
	@NotNull(message = "Campo Nao Pode Ser Nulo")
	@Size(max = 15)
	private String telefone;

	@Column(name = "cpf")
	@NotBlank(message = "Campo Obrigatorio")
	@NotNull(message = "Campo Nao Pode Ser Nulo")
	@Size(max = 15)
	private String cpf;
	
	@Column(name = "sexo")
	@NotBlank(message = "Campo Obrigatorio")
	@NotNull(message = "Campo Nao Pode Ser Nulo")
	@Size(max = 7)
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	


	

	public Cliente() {
	}

	public Cliente(Long id, String nome, Integer idade, String email, String endereco,
			String telefone, String cpf,Sexo sexo) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
		this.cpf = cpf;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
