package br.com.imd.whatDisease.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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

	public void apagar(Paciente paciente) throws CustomException {
		pacienteDAO.excluir(paciente);
	}
	
	public void gravar() throws CustomException {
		
		if(this.paciente.getId() == null) {
			pacienteDAO.salvar(this.paciente);
		} else {
			pacienteDAO.atualizar(this.paciente);
		}
	}
	
	
	public void editar(Paciente paciente) {
		this.paciente = paciente;
	}

}