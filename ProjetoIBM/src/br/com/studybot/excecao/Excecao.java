package br.com.studybot.excecao;

import java.sql.SQLException;

public class Excecao extends Exception{
	

	
	public static String tratarExcecao(Exception e) {
		
		if(e instanceof SQLException) {
			
			return "Erro no banco de dados";	
		}else if(e instanceof NumberFormatException) {
			return "Falha ao converter um numero";
		}else {
			return"Erro desconhecido";
			
		}
		
		
		
		
		
		
		
	}
}
