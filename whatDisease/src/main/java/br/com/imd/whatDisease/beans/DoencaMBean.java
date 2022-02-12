package br.com.imd.whatDisease.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.imd.whatDisease.DAO.DoencaDAO;
import br.com.imd.whatDisease.dominio.Doenca;
import br.com.imd.whatDisease.util.CustomException;
import lombok.Data;

@ManagedBean
@ViewScoped
@Data
public class DoencaMBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Doenca doenca = new Doenca();
	private DoencaDAO doencaDAO = new DoencaDAO();

	public void apagar(Doenca doenca) throws CustomException {
		doencaDAO.excluir(doenca);
	}
	
	public void gravar() throws CustomException {
		
		if(this.doenca.getId() == null) {
			doencaDAO.salvar(this.doenca);
		} else {
			doencaDAO.atualizar(this.doenca);
		}
	}
	
	
	public void editar(Doenca doenca) {
		this.doenca = doenca;
	}

}
