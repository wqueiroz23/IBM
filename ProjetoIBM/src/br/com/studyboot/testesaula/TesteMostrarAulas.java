package br.com.studyboot.testesaula;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.studybot.beans.Aula;
import br.com.studybot.dao.AulaDAO;

public class TesteMostrarAulas {

	public static void main(String[] args) {
		

		AulaDAO dao = null;

		try {
			/*List<Aula> aula1 = AulaBO.consultarPorNome(JOptionPane.showInputDialog("Digite um nome"));
			dao = new AulaDAO();
			List<Aula> lista = new ArrayList<Aula>();
			
			lista = dao.mostrarAula("");

			for (Aula aula : lista) {

				System.out.println(aula.getNome());

			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
