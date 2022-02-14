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

	public String apagar() throws CustomException {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Medico medico = (Medico) session.getAttribute("user");
		medicoDAO.excluir(medico);
		session.invalidate();
		return "index?faces-redirect=true";
	}
	
	public String gravar() throws CustomException {
		if(this.medico.getId() == null) {
			medicoDAO.salvar(this.medico);
			return "login?faces-redirect=true";
		} else {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			session.invalidate();
			return "";
		}
	}
	
	
	public void editar() throws CustomException {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Medico medico = (Medico) session.getAttribute("user");
		this.medico = medico;
		medicoDAO.atualizar(this.medico);
	}
}
