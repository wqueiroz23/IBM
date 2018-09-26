package br.com.studybot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.studybot.beans.Aluno;
import br.com.studybot.beans.Aula;
import br.com.studybot.beans.Curso;
import br.com.studybot.beans.Disciplina;
import br.com.studybot.beans.ItemPedido;
import br.com.studybot.beans.Pagamento;
import br.com.studybot.beans.Pedido;
import br.com.studybot.conexao.Conexao;

public class ItemPedidoDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	public ItemPedidoDAO() throws Exception {
		con = new Conexao().getConexao();
	}

	public String adicionarItem(ItemPedido item1) throws Exception {

		stmt = con.prepareStatement(
				" INSERT INTO T_STB_ITEM_PEDIDO (CD_ITEM_PEDIDO,VL_ITEM_PEDIDO,NR_ITEM,QT_VENDIDA,CD_PAGAMENTO,CD_PEDIDO,CD_CURSO"
						+ "VALUES(?,?,?,?,?,?,?");

		stmt.setInt(1, item1.getCodigo());
		stmt.setDouble(2, item1.getValor());
		stmt.setInt(3, item1.getNumero());
		stmt.setInt(4, item1.getQtVendida());
		stmt.setInt(5, item1.getPedido().getPagamento().getCodigo());
		stmt.setInt(6, item1.getPedido().getCodigo());
		stmt.setInt(7, item1.getCurso().getCodigo());

		stmt.executeUpdate();

		return "Cadastrado com sucesso";
	}

	public int excluirItemPedido(ItemPedido item) throws Exception {
		stmt = con.prepareStatement("DELETE FROM T_STB_ITEM_PEDIDO WHERE CD_ITEM_PEDIDO=?");
		stmt.setInt(1, item.getCodigo());
		return stmt.executeUpdate();
	}

	public List<ItemPedido>MostrarItems()throws Exception{
		List<ItemPedido>lista=new ArrayList<ItemPedido>();
		stmt=con.prepareStatement("SELECT*FROM T_STB_ITEM_PEDIDO INNER JOIN T_STB_PEDIDO\r\n" + 
				"ON (t_stb_item_pedido.cd_pedido=t_stb_pedido.cd_pedido)"+
				"SELECT * FROM T_STB_ITEM_PEDIDO INNER JOIN T_STB_CURSO"+
				"ON (t_stb_item_pedido.cd_curso=t_stb_curso.cd_curso))"+
				"SELECT * FROM T_STB_ITEM_PEDIDO INNER JOIN T_STB_PAGAMENTO"+
				"ON (t_stb_item_pedido.cd_pagamento=t_stb_pagamento.cd_pagamento)");
		
		rs=stmt.executeQuery();
		
		while(rs.next()) {
			lista.add(new ItemPedido(rs.getInt("CD_ITEM_PEDIDO"),rs.getDouble("VL_ITEM_PEDIDO"),rs.getInt("NR_ITEM"),rs.getInt("QT_VENDIDA"),new Pedido(rs.getInt("CD_PEDIDO"), rs.getString("DT_PEDIDO"),rs.getDouble("VL_TOTAL_PEDIDO"), new Aluno(rs.getInt("CD_ALUNO"),
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
					rs.getString("DT_ANO_FORMACAO")), new Pagamento()), new Curso(rs.getInt("CD_CURSO"), rs.getString("NM_CURSO"),rs.getString("DS_CURSO"),rs.getDouble("VL_CURSO"))));

		}
		
		/*   
					rs.getInt("CD_ITEM_PEDIDO"),
					rs.getDouble("VL_ITEM_PEDIDO"),
					rs.getInt("NR_ITEM"),
					rs.getInt("QT_VENDIDA"),
					new Pedido(
							rs.getInt("CD_PEDIDO"),
							rs.getString("DT_PEDIDO"),
							rs.getDouble("VL_TOTAL_PEDIDO"),
						
							new Aluno(
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
									rs.getString("DT_ANO_FORMACAO")
							),
					new Pagamento(
							rs.getInt("CD_PAGAMENTO"), 
							rs.getString("DS_TIPO_PAG")
					),	
					new Curso(
							rs.getInt("CD_CURSO"),
							rs.getString("NM_CURSO"),
							rs.getString("DS_CURSO"),
							rs.getDouble("VL_CURSO")
					)
		 * 
		 * */
		
		return lista;
		
		
		
	}

}
