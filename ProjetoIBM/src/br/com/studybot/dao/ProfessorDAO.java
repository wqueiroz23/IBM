package br.com.studybot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.studybot.beans.Disciplina;
import br.com.studybot.beans.Professor;
import br.com.studybot.conexao.Conexao;

public class ProfessorDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	public ProfessorDAO() throws Exception {
		this.con = new Conexao().getConexao();
	}

	public String addProfessor(Professor pro) throws Exception {
		PreparedStatement stmt = con.prepareStatement("INSERT INTO T_STB_PROFESSOR VALUES(?,?,?,?,?,?,?,?,?,?,?)");

		stmt.setInt(1, pro.getCodigo());
		stmt.setString(2, pro.getNome());
		stmt.setString(3, pro.getApelido());
		stmt.setString(4, pro.getRg());
		stmt.setString(5, pro.getCpf());
		stmt.setString(6, pro.getDataNascimento());
		stmt.setString(7, pro.getEmail());
		stmt.setString(8, pro.getTelefone());
		stmt.setString(9, pro.getSenha());
		stmt.setString(10, pro.getSexo());
		stmt.setInt(11, pro.getIdade());
		stmt.executeUpdate();

		return "Adicionado";
	}
	
	

	public int excluirProfessor(Professor pro) throws Exception {

		PreparedStatement stmt = con.prepareStatement("DELETE FROM T_STB_PROFESSOR WHERE CD_PROFESSOR=?");
		stmt.setInt(1, pro.getCodigo());
		return stmt.executeUpdate();
	}

	public void fechar() throws Exception {
		con.close();
	}
	
	
	public List<Professor>MostrarProfessor(int codigo)throws Exception{
		List<Professor>lista=new ArrayList<Professor>();
		stmt=con.prepareStatement("SELECT * FROM T_STB_PROFESSOR WHERE CD_PROFESSOR=?");
		stmt.setInt(1, codigo);
		
		while(rs.next()) {
			lista.add(new Professor(
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
					rs.getString ("DT_NASCIMENTO")));
		}
		rs.close();
		return lista;
	}

     
		
		
	
}
