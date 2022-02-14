package br.com.imd.whatDisease.util;

import org.hibernate.Session;
import org.junit.Test;

public class HibernateUtilTest {
	
	@Test
	public void conectar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close(); // fecha a sessao
		HibernateUtil.getFabricaDeSessoes().close(); // fecha a fabrica de sessoes
	}
	
}
