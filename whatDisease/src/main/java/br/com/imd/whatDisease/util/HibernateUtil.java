package br.com.imd.whatDisease.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory fabricaDeSessoes = criarFabricaDeSessoes();

    private static SessionFactory criarFabricaDeSessoes() {
        try {
        	Configuration configuracao = new Configuration();
        	configuracao.configure("hibernate_mysql.cfg.xml");
        	return configuracao.buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Erro na criação da fábrica de sessões: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getFabricaDeSessoes() {
        return fabricaDeSessoes;
    }
}
