package br.com.imd.whatDisease.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Medico implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 255, nullable = false)
	private String nome;
	
	@Column(length = 255, nullable = false)
	private String genero;

	@Column(nullable = false)
	private Integer idade;
	
	@Column(length = 255, nullable = false)
	private String registroMedico;

	public Medico() {
		super();
	}

	public Medico(Integer id, String nome, String genero, Integer idade, String registroMedico) {
		super();
		this.id = id;
		this.nome = nome;
		this.genero = genero;
		this.idade = idade;
		this.registroMedico = registroMedico;
	}
	
	
	
}
