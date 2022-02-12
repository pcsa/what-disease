package br.com.imd.whatDisease.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.imd.whatDisease.DAO.SintomaDAO;
import br.com.imd.whatDisease.dominio.Sintoma;
import br.com.imd.whatDisease.util.CustomException;
import lombok.Data;

@ManagedBean
@ViewScoped
@Data
public class SintomaMBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Sintoma sintoma = new Sintoma();
	private SintomaDAO sintomaDAO = new SintomaDAO();

	public void apagar(Sintoma sintoma) throws CustomException {
		sintomaDAO.excluir(sintoma);
	}
	
	public void gravar() throws CustomException {
		
		if(this.sintoma.getId() == null) {
			sintomaDAO.salvar(this.sintoma);
		} else {
			sintomaDAO.atualizar(this.sintoma);
		}
	}
	
	
	public void editar(Sintoma sintoma) {
		this.sintoma = sintoma;
	}

}
