package br.com.studyboot.testesaluno;

import javax.swing.JOptionPane;

import br.com.studybot.beans.Aluno;
import br.com.studybot.dao.AlunoDAO;

public class TesteAlunoGravar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Aluno aluno1 = new Aluno();
			aluno1.setHistorico("xxxxx");
			aluno1.setGrauEscolaridade("superior");
			aluno1.setDataFormacao("12/12/2019");
			aluno1.setCodigo(55);
			aluno1.setNome("Jonny");
			aluno1.setApelido("Jow");
			aluno1.setRg("xxxxxxx");
			aluno1.setCpf("39240888888");
			aluno1.setData("12/12/1990");
			aluno1.setEmail("w7queiroz@gmail.com");
			aluno1.setTelefone(11);
			aluno1.setSenha("will1566");
			aluno1.setSexo("M");
			aluno1.setIdade(28);

			AlunoDAO dao = new AlunoDAO();
			System.out.println(dao.addAluno(aluno1));

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
			System.out.println(e);
		}
	}

}
