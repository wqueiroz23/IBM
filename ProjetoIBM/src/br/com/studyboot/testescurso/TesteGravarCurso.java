package br.com.studyboot.testescurso;

import br.com.studybot.beans.Curso;
import br.com.studybot.dao.CursoDAO;

public class TesteGravarCurso {

	public static void main(String[] args) {

		try {
			Curso curso1 = new Curso();
			curso1.setCodigo(29);
			curso1.setNome("Ingles");
			curso1.setDescricao("Ingles Avançado");
			curso1.setValor(345);

			CursoDAO dao = new CursoDAO();
			System.out.println(dao.adicionar(curso1));

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

}
