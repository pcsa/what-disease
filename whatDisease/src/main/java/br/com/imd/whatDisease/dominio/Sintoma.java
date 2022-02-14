package br.com.imd.whatDisease.dominio;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Sintoma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 255, nullable = false)
	private String nome;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "sintomas", fetch = FetchType.EAGER)
	private Set<Doenca> doencas = new HashSet<>();

	public Sintoma(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Sintoma() {
		super();
	}

}
