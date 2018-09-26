package br.com.studyboot.bo;

import br.com.studybot.beans.Professor;
import br.com.studybot.dao.ProfessorDAO;

/**
 * @author studyBot
 * @version 1.0
 * @see ProfessorBO, Professor
 */


public class ProfessorBO {
	/*
	 * Classe responsável por manipular as regras relacionadas
	 * ao cadastro de aluno
	 * 
	 * codigo professor não pode ser < 1
	 * nome deve conter no máximo 50 caracteres
	 * deve possuir apelido com no mínimo 5 carácteres
	 * cpf deve conter 11 caracteres
	 * rg deve conter 9 caracteres
	 * email deve conter @
	 * sexo deve utilizar o caracter F para feminino e M para masculino
	 * senha deve possuir no mínimo 6 caracteres
	 * número de telefone deve possuir 10 digitos 2 para ddd e 8 para o número
	 * deve ser preenchido o código que comprove o número de formação
	 *
	 * 
	 */
	public static String novoProfessor(Professor objProfessor) throws Exception{
		
		if(objProfessor.getCodigo() < 1) {
			
			return "codigo invalido";
			
		}
		
		if(objProfessor.getNome().length()>50) {
			return   " Nome invalido";
		}
		
		if(objProfessor.getApelido().equals(null) || objProfessor.getApelido().length()< 5) {
			return " Digite um apelido com no minimo que 5 caracteres";
		}
		
		if(objProfessor.getCpf().length() <= 11) {
			return "Preencha os 11 numero do CPF";			
		}
		
		if(objProfessor.getRg().length() < 9) {
			return "Preencha os 9 numeros do seu RG ";
		}
		if(objProfessor.getEmail().indexOf("@") <= 2 || objProfessor.getEmail().indexOf(".")<= 3 || objProfessor.getEmail().length()>25) {
			
			return "Email invalido/ digite email@gmail.com";
			
		}
				
		if(!(objProfessor.getSexo().toUpperCase().contains("F") || objProfessor.getSexo().toUpperCase().contains("M"))){
			return "Sexo invalido - Digite (F) para Feminino ou (M) para Masculino ";
		}
		
		if(objProfessor.getSenha().length() < 6 ){
			 return " Sua senha deve ter no minimo 6 caracteres ";	
		}
		
		if(objProfessor.getTelefone().length() < 10) {
			return "Digite o DDD com 2 digitos e mais os 8 digitos do seu telefone";
			
		}
		
		if(objProfessor.getComprovantePagamento().length()<30) {
			 
			return "Digite o 5 codigo de seu comprovante de forma��o";
		}
				
		ProfessorDAO dao = new ProfessorDAO();
		dao.addProfessor(objProfessor);
		dao.fechar();
		return  "Gravado com sucesso";
		
	}
	


}
