package br.com.imd.whatDisease.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
	
	private Integer id;
	private String email;
	private String senha;
	private Boolean isMedic;

}
