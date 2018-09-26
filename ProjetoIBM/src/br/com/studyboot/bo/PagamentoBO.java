package br.com.studyboot.bo;

import br.com.studybot.beans.Pagamento;
import br.com.studybot.dao.PagamentoDAO;

/**
 * @author studyBot
 * @version 1.0
 * @see PagamentoBO, Pagamento
 * 
 */

public class PagamentoBO {
	
	/*
	 * Classe responsavel por manipular as regras relacionadas
	 * ao cadastro de pagamento
	 * 
	 * codigo pagamento não pode ser < 1
	 * descrição pode ter no máximo 20 caracteres
	 * 
	 */
	
	public static String entradaPagamento(Pagamento objPagamento) throws Exception{
		
		if(objPagamento.getCodigo() < 1) {
			return "Codigo invalido";
		}
		
		if(objPagamento.getDescricao().length() > 20) {
			return "A descrição deve ter no máximo 20 caracteres";
		}
		
		PagamentoDAO dao = new PagamentoDAO();
		dao.adicionar(objPagamento);
		return "Gravado com sucesso";
	}

}
