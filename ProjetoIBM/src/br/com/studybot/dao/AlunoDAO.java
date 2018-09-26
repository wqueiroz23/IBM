package br.com.studybot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.studybot.beans.Aluno;
import br.com.studybot.conexao.Conexao;

public class AlunoDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public AlunoDAO()throws Exception {
		this.con = new Conexao().getConexao();
	}
		public String addAluno(Aluno aluno)throws Exception {
		 stmt = con.prepareStatement("INSERT INTO T_STB_ALUNO VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		stmt.setString(1, aluno.getHistorico());
		stmt.setString(2, aluno.getGrauEscolaridade());
		stmt.setString(3, aluno.getDataFormacao());
		stmt.setInt(4, aluno.getCodigo());
		stmt.setString(5, aluno.getNome());
		stmt.setString(6, aluno.getApelido());
		stmt.setString(7, aluno.getRg());
		stmt.setString(8, aluno.getCpf());
		stmt.setString(9,aluno.getData());
		stmt.setString(10, aluno.getEmail());
		stmt.setInt(11,aluno.getTelefone());
		stmt.setString(12, aluno.getSenha());
		stmt.setString(13,String.valueOf(aluno.getSexo()));
		stmt.setInt(14, aluno.getIdade());

		stmt.executeUpdate();
		return "Adicionado"; 
		}	
		
		
		public int excluirAluno(Aluno aluno)throws Exception {
			stmt = con.prepareStatement("DELETE FROM T_STB_ALUNO WHERE CD_ALUNO=?");
			stmt.setInt(1, aluno.getCodigo());
			return stmt.executeUpdate();
		}
		
		public void fechar()throws Exception{
			con.close();
		}
		
		
		public List<Aluno> mostrarPorNome(String nome)throws Exception{
			List<Aluno>lista=new ArrayList<Aluno>();
			
			stmt=con.prepareStatement("SELECT * FROM T_STB_ALUNO WHERE NM_ALUNO LIKE ?");
			stmt.setString(1, nome + "%");
			rs=stmt.executeQuery();
			while(rs.next()) {
				lista.add(new Aluno(
						rs.getInt("CD_ALUNO"),
						rs.getString("NM_ALUNO"),
						rs.getString("NM_APELIDO"),
						rs.getString("NR_RG"),
						rs.getString("NR_CPF"),
						rs.getString("DS_EMAIL"),
						rs.getInt("NR_TELEFONE"),
						rs.getString("NR_SENHA"),
						rs.getString("DS_SEXO"),
						rs.getInt("NR_IDADE"),
						rs.getString("DT_NASCIMENTO"),
						rs.getString("DS_HISTORICO"),
						rs.getString("DS_GRAU_ESCOLARIDADE"),
						rs.getString("DT_ANO_FORMACAO")));
			}
			
			rs.close();
			
			
			return lista;
			
		}
		
		
}
