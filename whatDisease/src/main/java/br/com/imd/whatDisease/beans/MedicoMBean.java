package br.com.imd.whatDisease.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

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
			return "login?faces-redirect=true";
		} else {
			//medicoDAO.atualizar(this.medico);
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			session.invalidate();
			return "";
		}
	}
	
	
	public void editar(Medico medico) {
		this.medico = medico;
	}
}
