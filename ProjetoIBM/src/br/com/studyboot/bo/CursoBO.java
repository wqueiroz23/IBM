package br.com.studyboot.bo;


import java.util.List;

import br.com.studybot.beans.Curso;
import br.com.studybot.dao.CursoDAO;

/**
 * 
 * @author studyBot
 * @version 1.0
 * @see CursBO, Curso
 *
 */

public class CursoBO {
	
	
	/**
	 * 
	 * @param objCurso
	 * @return
	 * @throws Exception
	 *
	 * Classe responsavel por manipular as regras relacionadas
	 * ao cadastro de curso
	 * 
	 * Codigo do curso permitido > que 1 (getCodigo)
	 * Nome do curso deve ter no maximo 30 caracteres (getNome)
	 * Descrição deve ter no maximo 40 caracteres  (getDescricao)
	 * valor do curso deve ser no minimo 150 (getValor)
	 * 
	 * 
	 */


	public static String AdicionarCurso(Curso objCurso) throws Exception{

		if(objCurso.getCodigo() < 1) {
			return "Codigo invalido";
		}

		if(objCurso.getCodigo() == objCurso.getCodigo()) {
			return "codigo invalido";
		}

		if(objCurso.getNome().length() > 30) {
			return "Nome do curso excedeu o numero de caracter";
		}

		if(objCurso.getDescricao().length() > 40) {
			return "Informe a descrição do curso"; 
		}

		if(objCurso.getValor() < 150) {

			return "Valor invalido";
		}

		CursoDAO dao = new CursoDAO();
		dao.adicionar(objCurso);
		dao.fechar();
		return "Gravado com sucesso";
	}
	
	public static String ExcluirCurso(Curso objCurso)throws Exception {
		if(!(objCurso.getNome()==objCurso.getNome())) {
			return "Digite o nome do curso correto";
		}
		CursoDAO dao = new CursoDAO();
		dao.excluirCurso(objCurso);
		dao.fechar();
		return null;
		
		
	}
	
	public static List<Curso>consultarPornOme(String n)throws Exception{
		
		CursoDAO dao =new CursoDAO();
		List<Curso>x =dao.mostrarCursos(n);
		dao.fechar()
;		return x;
		
	}

}
