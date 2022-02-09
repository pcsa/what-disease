package br.com.imd.whatDisease.dominio;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Medico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO INCREMENT
	private Integer id;
	
	@Column(length = 255, nullable = false)
	private String nome;
	
	@Column(length = 255, nullable = false)
	private String especialidade;
	
	@Column(length = 255, nullable = false)
	private String registroMedico; // nao foi colocado crm pois existem outros tipos tambem de registros

	public Medico(String nome, String especialidade, String registroMedico) {
		super();
		this.nome = nome;
		this.especialidade = especialidade;
		this.registroMedico = registroMedico;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getRegistroMedico() {
		return registroMedico;
	}

	public void setRegistroMedico(String registroMedico) {
		this.registroMedico = registroMedico;
	}

	@Override
	public int hashCode() {
		return Objects.hash(especialidade, id, nome, registroMedico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medico other = (Medico) obj;
		return Objects.equals(especialidade, other.especialidade) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(registroMedico, other.registroMedico);
	}
	
	
}
