package br.com.studyboot.testescurso;

import javax.swing.JOptionPane;

import br.com.studybot.beans.Curso;
import br.com.studybot.dao.CursoDAO;

public class TesteExcluirCurso {

	public static void main(String[] args) {
		
		try {
			Curso curso1=new Curso();
			curso1.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do curso a ser excluido")));
			CursoDAO dao =new CursoDAO();
			System.out.println(dao.excluirCurso(curso1)+
					"cursos foram excluidos com sucesso");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e);
		}

	}

}
