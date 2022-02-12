package br.com.imd.whatDisease.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory fabricaDeSessoes = criarFabricaDeSessoes();

    private static SessionFactory criarFabricaDeSessoes() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
//            return new Configuration().configure().buildSessionFactory(
//			    new StandardServiceRegistryBuilder().build() );
        	Configuration configuracao = new Configuration();
        	configuracao.configure("hibernate_postgres.cfg.xml");
        	return configuracao.buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Erro na criação da fábrica de sessões: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getFabricaDeSessoes() {
        return fabricaDeSessoes;
    }
}
