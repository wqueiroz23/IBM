package br.com.studyboot.testesaluno;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.studybot.beans.Aluno;
import br.com.studybot.dao.AlunoDAO;

public class TesteMostrarAluno {

	public static void main(String[] args) {

		AlunoDAO dao = null;

		try {
			dao = new AlunoDAO();
			List<Aluno> lista = new ArrayList<Aluno>();
			String nome = JOptionPane.showInputDialog("Digite um nome ");

			lista = dao.mostrarPorNome("");

			for (Aluno aluno : lista) {

				System.out.println(aluno.getNome());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
