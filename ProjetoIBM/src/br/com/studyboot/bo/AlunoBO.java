package br.com.studyboot.bo;

import java.util.List;

import br.com.studybot.beans.Aluno;
import br.com.studybot.dao.AlunoDAO;

public class AlunoBO {

	public static String novoAluno(Aluno aluno1) throws Exception {

		if (aluno1.getCodigo() < 1) {
			return "Codigo Invalido";
		}
		if (aluno1.getNome().length() > 50) {
			return "Nome invalido";

		}

		AlunoDAO dao = new AlunoDAO();
		String msg = dao.addAluno(aluno1);
		dao.fechar();
		return msg;
	}

	public static int apagarPorCodigo(Aluno n) throws Exception {
		AlunoDAO dao = new AlunoDAO();
		int x = dao.excluirAluno(n);
		dao.fechar();
		return x;
	}
	
	public static List<Aluno>consultarPorNome(String n)throws Exception{
		
		AlunoDAO dao =new AlunoDAO();
		List<Aluno> x=dao.mostrarPorNome(n);
		dao.fechar();
		return x;
		
	}

}
