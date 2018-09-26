package br.com.studybot.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Conexao {
	
	public Connection getConexao() throws Exception {
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","will121290");
	}

}
