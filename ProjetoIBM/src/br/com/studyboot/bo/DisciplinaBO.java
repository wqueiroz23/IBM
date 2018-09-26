package br.com.studyboot.bo;

import java.util.List;

import br.com.studybot.beans.Disciplina;
import br.com.studybot.dao.DisciplinaDAO;

/**
 * 
 * @author studyBot
 * @version 1.0
 * @see DisciplinaBO, Disciplina
 *
 */

public class DisciplinaBO {

	/**
	 * 
	 * @param objDisciplina
	 * @return
	 * @throws Exception
	 */

	/*
	 * Classe responsavel por manipular as regras relacionadas ao cadastro de
	 * disciplina
	 * 
	 * Codigo da disciplina permitido > 1 (getCodigo) Nome disciplina deve ter no
	 * maximo 30 caracteres (getNome) Descrição disciplina deve ter no maximo 40
	 * caracteres
	 */

	public static String tipoDisciplina(Disciplina objDisciplina) throws Exception {

		if (objDisciplina.getCodigo() < 1) {
			return "Codigo invalido, digite novamente";

		}

		if (objDisciplina.getNome().length() > 30) {
			return "Digite até 30 caracteres no nome da disciplina ";
		}

		if (objDisciplina.getDescricao().length() > 40) {
			return "Digite até 40 caracteres na descrição ";

		}

		DisciplinaDAO dao = new DisciplinaDAO();
		String n = dao.adicionar(objDisciplina);
		dao.fechar();
		return n;
	}

	public static int apagarPorNome(Disciplina n) throws Exception {
		DisciplinaDAO dao = new DisciplinaDAO();
		int x = dao.excluirDisciplina(n);
		dao.fechar();
		return x;
	}

	public static List<Disciplina> consultarDisciplina(String n) throws Exception {

		DisciplinaDAO dao = new DisciplinaDAO();
		List<Disciplina> x = dao.MostrarDisciplinas(n);
		dao.fechar();

		return x;
	}

}
