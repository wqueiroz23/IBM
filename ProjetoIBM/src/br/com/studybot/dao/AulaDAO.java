package br.com.studybot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.studybot.beans.Aula;
import br.com.studybot.beans.Curso;
import br.com.studybot.beans.Disciplina;
import br.com.studybot.beans.Professor;
import br.com.studybot.conexao.Conexao;

public class AulaDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	public AulaDAO() throws Exception {
		con = new Conexao().getConexao();

	}

	public String fechar() throws Exception {

		con.close();
		return "fechou";
	}

	public String adicionar(Aula a1) throws Exception {

		stmt = con.prepareStatement(
				"INSERT INTO T_STB_AULA (CD_AULA, NM_AULA, DS_DURACAO, CD_DISCIPLINA, CD_CURSO, CD_PROFESSOR)+ VALUES(?,?,?,?,?,?)");
		stmt.setInt(1, a1.getCodigo());
		stmt.setString(2, a1.getNome());
		stmt.setString(3, a1.getDescricao());
		stmt.setInt(3,a1.getProfessor().getCodigo());
		stmt.setInt(5, a1.getCurso().getCodigo());
		stmt.setInt(6, a1.getDisciplina().getCodigo());

		stmt.executeUpdate();

		return "Cadastrado com sucesso";
	}

	public int excluirAula(Aula aula1) throws Exception {
		stmt = con.prepareStatement("DELETE FROM T_STB_AULA WHERE CD_AULA=?");
		stmt.setInt(1, aula1.getCodigo());
		return stmt.executeUpdate();
	}

	public List<Aula> mostrarAula(String nome) throws SQLException {

		List<Aula> lista = new ArrayList<Aula>();
		stmt = con.prepareStatement(
				"SELECT * FROM T_STB_AULA INNER JOIN T_STB_CURSO "
				+ "ON (T_STB_AULA.CD_CURSO = T_STB_CURSO.CD_CURSO)" 
				+ "INNER JOIN T_STB_PROFESSOR ON (T_STB_AULA.CD_PROFESSOR = T_STB_PROFESSOR.CD_PROFESSOR)" 
				+ "INNER JOIN T_STB_DISCIPLINA ON(T_STB_AULA.CD_DISCIPLINA = T_STB_DISCIPLINA.CD_DISCIPLINA)"
				+ " WHERE  NM_AULA LIKE ?");

		stmt.setString(1, nome + "%");
		rs = stmt.executeQuery();

		while (rs.next()) {
			lista.add(new Aula(
					rs.getInt("CD_AULA"),
					rs.getString("NM_AULA"),
					rs.getString("DS_DURACAO"),
					new Disciplina(
							rs.getInt("CD_DISCIPLINA"),
							rs.getString("NM_DISCIPLINA"),
							rs.getString("DS_AREA")), 
					new Curso(
							rs.getInt("CD_CURSO"),
							rs.getString("NM_CURSO"),
							rs.getString("DS_CURSO"),
							rs.getDouble("VL_CURSO")), 
					new Professor(
							rs.getInt("CD_PROFESSOR"),
							rs.getString("NM_PROFESSOR"),
							rs.getString("NM_APELIDO"),
							rs.getString("NR_RG"),
							rs.getString ("NR_CPF"),
							rs.getString("DS_EMAIL"),
							rs.getString("NR_TELEFONE"),
							rs.getString("DS_SEXO"),
							rs.getInt("NR_IDADE"),
							rs.getString ("DS_COMPROVANTE_PAGAMENTO"),
							rs.getString ("DT_NASCIMENTO"))));

		}
		rs.close();

		return lista;

	}

}
