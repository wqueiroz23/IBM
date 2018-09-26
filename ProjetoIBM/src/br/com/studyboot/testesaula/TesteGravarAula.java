package br.com.studyboot.testesaula;

import br.com.studybot.beans.Aula;
import br.com.studybot.beans.Curso;
import br.com.studybot.beans.Disciplina;
import br.com.studybot.beans.Professor;
import br.com.studybot.dao.AulaDAO;

public class TesteGravarAula {

	public static void main(String[] args) {

		try {
			Aula a = new Aula();

			a.setCodigo(17);
			a.setNome("Java");
			a.setDescricao("Aula de Java Web");
			
			Professor p =new Professor();
			p.setNome("Jão");
			p.setApelido("Jo");
			p.setRg("7777777777");
			p.setCpf("33333333333333333");
			p.setTelefone("23580451");
			p.setSenha("12345678");
			p.setSexo("M");
			p.setIdade(27);
			p.setComprovantePagamento("ok");
			p.setDataNascimento("12/12/1990");
			
			Curso c=new Curso();
			c.setCodigo(157);
			c.setNome("TDS");
			c.setDescricao("Tecnoloogia");
			c.setValor(300);
			
			Disciplina d= new Disciplina();
			
			d.setCodigo(37);
			d.setNome("DDD");
			d.setDescricao("zzzzz");
			

			AulaDAO dao = new AulaDAO();
			System.out.println(dao.adicionar(a));

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}

	}

}
