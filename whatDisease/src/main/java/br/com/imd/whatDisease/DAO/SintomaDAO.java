package br.com.imd.whatDisease.DAO;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.imd.whatDisease.dominio.Sintoma;
import br.com.imd.whatDisease.util.CustomException;
import br.com.imd.whatDisease.util.HibernateUtil;

public class SintomaDAO extends GenericDAO<Sintoma> {
	private static final long serialVersionUID = 1L;
	
	public Sintoma buscarNome(String nome) throws CustomException {
		// 1. Abre a sessao
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Sintoma sintoma = null;
		try {
			Query<?> query = sessao.createQuery("from Category where name=:name");
			query.setParameter("name", nome);
			
			sintoma = (Sintoma) query.uniqueResult();

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
		return sintoma;
	}
}
