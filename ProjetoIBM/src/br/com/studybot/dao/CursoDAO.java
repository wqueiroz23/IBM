package br.com.studybot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.studybot.beans.Curso;
import br.com.studybot.conexao.Conexao;

public class CursoDAO {
	
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	public CursoDAO()throws Exception{
		con=new Conexao().getConexao();
	}
	public String fechar()throws Exception{
		
		con.close();
		return "fechou";
	}
	
	public String adicionar(Curso curso1) throws Exception{
		stmt=con.prepareStatement("INSERT INTO T_STB_CURSO"
				+"(CD_CURSO,NM_CURSO,DS_CURSO,VL_CURSO)"
				+ "VALUES(?,?,?,?)");
		stmt.setInt   (1, curso1.getCodigo());
		stmt.setString(2, curso1.getNome());;
		stmt.setString(3, curso1.getDescricao());
		stmt.setDouble(4, curso1.getValor());
		stmt.executeUpdate();
		return"Cadastrado com sucesso";
		}
	
	public int excluirCurso(Curso curso1)throws Exception {
		stmt = con.prepareStatement("DELETE FROM T_STB_CURSO WHERE CD_CURSO=?");
		stmt.setInt(1, curso1.getCodigo());
		return stmt.executeUpdate();
	}
	
	public List<Curso>mostrarCursos(String nome)throws Exception{
		
		List<Curso>lista=new ArrayList<>();
		stmt=con.prepareStatement("SELECT * FROM T_STB_CURSO WHERE NM_CURSO LIKE ?");
		
		stmt.setString(1, nome+"%");
		rs=stmt.executeQuery();
		
		while(rs.next()) {
			lista.add(new Curso(
					rs.getInt("CD_CURSO"),
					rs.getString("NM_CURSO"),
					rs.getString("DS_CURSO"),
					rs.getDouble("VL_CURSO")));
		}
		rs.close();
		return lista;
		
		
	}
	
	

	

}
