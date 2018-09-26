package br.com.studybot.testeConexao;

import java.sql.Connection;

import br.com.studybot.conexao.Conexao;

public class TesteConexao {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		Connection con=null;
		try {
			con = new Conexao().getConexao();
			System.out.println("Abriu");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e);
		}finally {
			try {
				con.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println(e);
			}
			
		}
	

	}
}