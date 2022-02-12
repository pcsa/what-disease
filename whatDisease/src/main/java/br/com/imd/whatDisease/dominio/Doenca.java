package br.com.imd.whatDisease.dominio;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Doenca implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 255, nullable = false)
	private String nome;
	
	@ManyToMany
	@JoinTable(	name = "tb_doenca_sintoma",
				joinColumns = @JoinColumn(name = "doenca_id"),
				inverseJoinColumns = @JoinColumn(name = "sintoma_id") )
	private Set<Sintoma> sintomas = new HashSet<>();
	
	public Doenca(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Doenca() {
		super();
	}

}
