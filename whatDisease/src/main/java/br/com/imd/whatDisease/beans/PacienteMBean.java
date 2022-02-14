package br.com.imd.whatDisease.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.imd.whatDisease.DAO.PacienteDAO;
import br.com.imd.whatDisease.dominio.Paciente;
import br.com.imd.whatDisease.util.CustomException;
import lombok.Data;

@ManagedBean
@ViewScoped
@Data
public class PacienteMBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Paciente paciente = new Paciente();
	private PacienteDAO pacienteDAO = new PacienteDAO();

	public String apagar() throws CustomException {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Paciente paciente = (Paciente) session.getAttribute("user");
		pacienteDAO.excluir(paciente);
		session.invalidate();
		return "index?faces-redirect=true";
	}
	
	public String gravar() throws CustomException {
		
		if(this.paciente.getId() == null) {
			pacienteDAO.salvar(this.paciente);
			return "login?faces-redirect=true";
		} else {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			session.invalidate();
			return "";
		}
	}
	
	
	public void editar() throws CustomException {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Paciente paciente = (Paciente) session.getAttribute("user");
		this.paciente = paciente;
		pacienteDAO.atualizar(this.paciente);
	}

}
