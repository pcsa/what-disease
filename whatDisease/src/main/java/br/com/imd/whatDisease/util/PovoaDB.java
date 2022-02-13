package br.com.imd.whatDisease.util;

import java.util.List;

import br.com.imd.whatDisease.DAO.DoencaDAO;
import br.com.imd.whatDisease.DAO.MedicoDAO;
import br.com.imd.whatDisease.DAO.PacienteDAO;
import br.com.imd.whatDisease.DAO.SintomaDAO;
import br.com.imd.whatDisease.dominio.Doenca;
import br.com.imd.whatDisease.dominio.Medico;
import br.com.imd.whatDisease.dominio.Paciente;
import br.com.imd.whatDisease.dominio.Sintoma;

public class PovoaDB {

	public static void main(String[] args) {
		dados();
	}

	public static void dados() {

		try {

			MedicoDAO medicoDAO = new MedicoDAO();
			PacienteDAO pacienteDAO = new PacienteDAO();
			DoencaDAO doencaDAO = new DoencaDAO();
			SintomaDAO sintomaDAO = new SintomaDAO();

			String[] arraySintomas = new String[] { "Coriza e sinusite", "Falta de ar", "Dor no corpo", "Febre",
					"Dor atrás dos olhos", "Dor de cabeça", "Enjoo", "Manchas vermelhas na pele", "Cansaço excessivo",
					"Dor nas articulações e ossos", "Sangramentos pelo nariz, olhos ou gengivas",
					"Urina rosa, vermelha ou marrom", "Tonturas", "Visão ofuscada ou manchas de luz no campo de visão",
					"Sensibilidade à luz, ruído ou cheiro", "Espirros", "Dor muscular",
					"Dor persistente ou pressão no peito", "Confusão" };
			System.out.println("Início da gravação das tabelas");

			Doenca gripe = new Doenca(null, "Gripe");
			Doenca covid = new Doenca(null, "Covid-19");
			Doenca resfriado = new Doenca(null, "Resfriado");
			Doenca dengue = new Doenca(null, "Dengue");
			Doenca enxaq = new Doenca(null, "Enxaqueca");

			doencaDAO.salvar(gripe);
			doencaDAO.salvar(covid);
			doencaDAO.salvar(resfriado);
			doencaDAO.salvar(dengue);
			doencaDAO.salvar(enxaq);

			System.out.println("Gerou a tabela de Doencas");

			Sintoma sintoma;
			for (int i = 0; i < arraySintomas.length; i++) {
				sintoma = new Sintoma(null, arraySintomas[i]);
				sintomaDAO.salvar(sintoma);
			}

			System.out.println("Gerou a Tabela de Sintomas");

			List<Sintoma> sintomas = sintomaDAO.listar();

			sintomas.forEach(s -> {
				String tmp = s.getNome();
				// Adicionar sintomas da gripe
				if (tmp.equals("Coriza e sinusite") || tmp.equals("Febre") || tmp.equals("Dor de cabeça")
						|| tmp.equals("Espirros") || tmp.equals("Dor muscular") || tmp.equals("Cansaço excessivo")) {
					try {
						gripe.getSintomas().add(s);
					} catch (RuntimeException e) {
						System.out.println(e);
					}
				}
				// Adicionar sintomas da covid
				if (tmp.equals("Dor persistente ou pressão no peito") || tmp.equals("Febre")
						|| tmp.equals("Dor de cabeça") || tmp.equals("Confusão") || tmp.equals("Falta de ar")
						|| tmp.equals("Cansaço excessivo")) {
					try {
						covid.getSintomas().add(s);
					} catch (RuntimeException e) {
						System.out.println(e);
					}
				}
				// Adicionar sintomas da dengue
				if (tmp.equals("Dor atrás dos olhos") || tmp.equals("Febre") || tmp.equals("Dor de cabeça")
						|| tmp.equals("Manchas vermelhas na pele") || tmp.equals("Dor muscular")
						|| tmp.equals("Urina rosa, vermelha ou marrom")
						|| tmp.equals("Sangramentos pelo nariz, olhos ou gengivas")
						|| tmp.equals("Dor nas articulações e ossos") || tmp.equals("Dor nas articulações e ossos")
						|| tmp.equals("Manchas vermelhas na pele")) {
					try {
						dengue.getSintomas().add(s);
					} catch (RuntimeException e) {
						System.out.println(e);
					}
				}
				// Adicionar sintomas da resfriado
				if (tmp.equals("Coriza e sinusite") || tmp.equals("Febre") || tmp.equals("Dor de cabeça")) {
					try {
						resfriado.getSintomas().add(s);
					} catch (RuntimeException e) {
						System.out.println(e);
					}
				}
				// Adicionar sintomas da Enxaqueca
				if (tmp.equals("Sensibilidade à luz, ruído ou cheiro")
						|| tmp.equals("Visão ofuscada ou manchas de luz no campo de visão")
						|| tmp.equals("Dor de cabeça") || tmp.equals("Tonturas")) {
					try {
						enxaq.getSintomas().add(s);
					} catch (RuntimeException e) {
						System.out.println(e);
					}
				}
			});
			try {
				doencaDAO.atualizar(gripe);
				doencaDAO.atualizar(covid);
				doencaDAO.atualizar(resfriado);
				doencaDAO.atualizar(dengue);
				doencaDAO.atualizar(enxaq);
			} catch (CustomException e) {
				e.printStackTrace();
			}

			System.out.println("Relacionamento doenca-sintoma gerado!");

			pacienteDAO.salvar(new Paciente(null, "Paciente1", "123", "power_poul", "M", 35, 100.0, 1.75));

			System.out.println("Pacientes salvos!");

			medicoDAO.salvar(new Medico(null, "Medico1", "123", "power_poul", "M", 30, "12345"));
			medicoDAO.salvar(new Medico(null, "Medico2", "123", "gabi", "F", 28, "54321"));
			System.out.println("Medicos salvos!");

			System.out.println("Finalizou a geração de tabelas!");
			
			/*System.out.println("\n\nImprimindo sintomas da gripe:");
			
			gripe.getSintomas().forEach( s -> {
				System.out.println(s.getNome());
			});*/

			System.exit(0);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
