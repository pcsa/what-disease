package br.com.imd.whatDisease.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



import br.com.imd.whatDisease.DAO.MedicoDAO;
import br.com.imd.whatDisease.dominio.Medico;
import br.com.imd.whatDisease.util.CustomException;
import lombok.Data;

@ManagedBean
@ViewScoped
@Data
public class MedicoMBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Medico medico = new Medico();
	private MedicoDAO medicoDAO = new MedicoDAO();

	public void apagar(Medico medico) throws CustomException {
		medicoDAO.excluir(medico);
	}
	
	public String gravar() throws CustomException {
		if(this.medico.getId() == null) {
			medicoDAO.salvar(this.medico);
			return "/login.xhtml";
		} else {
			medicoDAO.atualizar(this.medico);
			return "";
		}
	}
	
	
	public void editar(Medico medico) {
		this.medico = medico;
	}
}
