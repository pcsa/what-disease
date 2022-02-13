package br.com.imd.whatDisease.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.imd.whatDisease.dominio.Paciente;
import br.com.imd.whatDisease.util.CustomException;
import br.com.imd.whatDisease.util.HibernateUtil;

public class PacienteDAO extends GenericDAO<Paciente> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Integer checkLogin(String email, String senha) throws CustomException {
		// 1. Abre a sessao
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		List<Paciente> pacientes = null;
		Paciente paciente = new Paciente();
		try {
			sessao.getTransaction().begin();

			CriteriaQuery<Paciente> query = sessao.getCriteriaBuilder().createQuery(Paciente.class);
			query.select(query.from(Paciente.class));
			pacientes = sessao.createQuery(query).getResultList();
			sessao.getTransaction().commit();
			if(pacientes != null) {
				pacientes.forEach( p -> {
					if(p.getEmail().equals(email) && p.getSenha().equals(senha)) {
						paciente.setId(p.getId());
					}
				});
			}

		} catch (HibernateException he) {
			if (sessao.getTransaction().isActive()) {
				sessao.getTransaction().rollback();
			}
			throw new CustomException("Erro ao buscar nome do registro: " + he.getMessage());
		} finally {
			if (sessao.isOpen()) {
				sessao.close();
			}
		}
		return paciente.getId();
	}
}
