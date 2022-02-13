package br.com.imd.whatDisease.beans;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.imd.whatDisease.DAO.MedicoDAO;
import br.com.imd.whatDisease.DAO.PacienteDAO;
import br.com.imd.whatDisease.dominio.Medico;
import br.com.imd.whatDisease.dominio.Paciente;
import br.com.imd.whatDisease.dominio.Usuario;
import br.com.imd.whatDisease.util.CustomException;
import lombok.Data;

@ManagedBean
@SessionScoped
@Data
public class UsuarioMBean {

	private PacienteDAO pacienteDAO = new PacienteDAO();
	private MedicoDAO medicoDAO = new MedicoDAO();

	private Medico medico = new Medico();
	private Paciente paciente = new Paciente();
	private Usuario usuario = new Usuario();

	public String login() throws CustomException {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		if (this.usuario.getIsMedic()) {
			Integer userID = medicoDAO.checkLogin(this.usuario.getEmail(), this.usuario.getSenha());		
			if(userID == null) {
				facesContext.addMessage("Post", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registro medico não encontrado.", ""));
				return "";
			}else {
				this.medico = medicoDAO.buscarId(userID);
				HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
				session.setAttribute("user", this.medico);
				return "index?faces-redirect=true";
			}
		} else {
			Integer userID = pacienteDAO.checkLogin(this.usuario.getEmail(), this.usuario.getSenha());
			if(userID == null) {
				facesContext.addMessage("Post", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registro de paciente não encontrado.", ""));
				return "";
			}else {
				this.paciente = pacienteDAO.buscarId(userID);
				HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
				session.setAttribute("user", this.paciente);
				return "index?faces-redirect=true";
			}
		}
	}
}
