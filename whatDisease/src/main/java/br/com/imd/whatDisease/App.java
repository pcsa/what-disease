package br.com.imd.whatDisease;

import br.com.imd.whatDisease.beans.MedicoMBean;
import br.com.imd.whatDisease.dominio.Medico;
import br.com.imd.whatDisease.util.CustomException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        MedicoMBean m = new MedicoMBean();
        m.editar(new Medico(null, "Medico1", "M", 30, "12345" ));
        try {
			m.gravar();
		} catch (CustomException e) {
			e.printStackTrace();
		}
    }
}
