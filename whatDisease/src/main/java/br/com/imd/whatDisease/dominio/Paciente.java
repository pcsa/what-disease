package br.com.imd.whatDisease.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 255, nullable = false)
	private String nome;
	
	@Column(length = 255, nullable = false)
	private String email;
	
	@Column(length = 255, nullable = false)
	private String senha;
	
	@Column(length = 255, nullable = false)
	private String genero;
	
	@Column(nullable = false)
	private Integer idade;
	
	@Column(nullable = false, precision = 2)
	private Double peso;
	
	@Column(nullable = false, precision = 2)
	private Double altura;

	public String getClassy(){
		return this.getClass();
	}
}
