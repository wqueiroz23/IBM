package br.com.studyboot.testesaula;

import javax.swing.JOptionPane;

import br.com.studybot.beans.Aula;
import br.com.studybot.dao.AulaDAO;

public class TesteExcluirAula {

	public static void main(String[] args) {
		
		
		try {
			Aula aula1 = new Aula();
			aula1.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do aluno para ser excluido")));
			AulaDAO dao = new AulaDAO();
			System.out.println(dao.excluirAula(aula1) + 
					" aulas(s) foi(ram) apagado(s)!");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

}
