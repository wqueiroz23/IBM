package br.com.studyboot.bo;


import br.com.studybot.beans.Pedido;
import br.com.studybot.dao.PedidoDAO;

public class PedidoBO {
	
	public static String entradaPedido(Pedido objPedido) throws Exception{
		
		if(objPedido.getCodigo() < 1) {
			return "Codigo invalido";
		}
		
		if(objPedido.getData().length() < 10  &&  objPedido.getData().length() > 10) {
			return "Data invalida, digite DD/MM/AAAA";
			
		}
		
		if(objPedido.getAluno().getCodigo() < 0) {
			return "Codigo aluno invalido";
		}
		
		if(objPedido.getValor() < 0) {
			return "Valor invalido";
		}
		PedidoDAO dao = new PedidoDAO();
		dao.adicionar(objPedido);
		dao.fechar();
		
		return null;
	}

}

