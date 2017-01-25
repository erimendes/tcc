package com.pendencias.model;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


import java.io.Serializable;
import java.util.Date;

@Entity
public class Usuario implements Serializable {
	@Id
	@GeneratedValue
	private Integer codigo;
	private String nome;
	@org.hibernate.annotations.NaturalId 
	private String login;
	private String senha;
	public Set<String> getPermissao() {
		return permissao;
	}

	public void setPermissao(Set<String> permissao) {
		this.permissao = permissao;
	}

	private String idioma;
	private boolean ativo;
	@ElementCollection(targetClass = String.class) 
	@JoinTable(
			name="usuario_permissao", 
			uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario","permissao"})}, 
			joinColumns = @JoinColumn(name = "usuario")) 
	@Column(name = "permissao", length=50) 
	private Set<String>	permissao	= new HashSet<String>(); 


	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((idioma == null) ? 0 : idioma.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((permissao == null) ? 0 : permissao.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		Usuario other = (Usuario) obj;
		if (ativo != other.ativo)
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (idioma == null) {
			if (other.idioma != null)
				return false;
		} else if (!idioma.equals(other.idioma))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (permissao == null) {
			if (other.permissao != null)
				return false;
		} else if (!permissao.equals(other.permissao))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

}
