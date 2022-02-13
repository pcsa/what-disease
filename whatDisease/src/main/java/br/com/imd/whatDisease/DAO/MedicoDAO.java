package br.com.imd.whatDisease.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import br.com.imd.whatDisease.dominio.Medico;
import br.com.imd.whatDisease.util.CustomException;
import br.com.imd.whatDisease.util.HibernateUtil;

public class MedicoDAO extends GenericDAO<Medico> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Integer checkLogin(String email, String senha) throws CustomException {
		// 1. Abre a sessao
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		List<Medico> medicos = null;
		Medico medico = new Medico();
		try {
			sessao.getTransaction().begin();

			CriteriaQuery<Medico> query = sessao.getCriteriaBuilder().createQuery(Medico.class);
			query.select(query.from(Medico.class));
			medicos = sessao.createQuery(query).getResultList();
			sessao.getTransaction().commit();
			if(medicos != null) {
				medicos.forEach( m -> {
					if(m.getEmail().equals(email) && m.getSenha().equals(senha)) {
						medico.setId(m.getId());
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
		return medico.getId();
	}
}
