package br.com.studybot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.studybot.beans.Aluno;
import br.com.studybot.beans.Pagamento;
import br.com.studybot.beans.Pedido;
import br.com.studybot.conexao.Conexao;

public class PedidoDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	public PedidoDAO() throws Exception {
		con = new Conexao().getConexao();
	}

	public String fechar() throws Exception {

		con.close();
		return "fechou";
	}

	public String adicionar(Pedido p) throws Exception {

		stmt = con.prepareStatement(
				"INSERT INTO T_STB_PEDIDO(CD_PEDIDO,DT_PEDIDO,VL_TOTAL_PEDIDO,CD_PAGAMENTO,CD_ALUNO) VALUES (?,?,?,?,?)");
		stmt.setInt(1, p.getCodigo());
		stmt.setString(2, p.getData());
		stmt.setDouble(3, p.getValor());
		stmt.setInt(4, p.getPagamento().getCodigo());
		stmt.setInt(5, p.getAluno().getCodigo());

		stmt.executeUpdate();
		return "Cadastrado com sucesso";
	}

	public int excluirPedido(Pedido ped) throws Exception {
		stmt = con.prepareStatement("DELETE FROM T_STB_PEDIDO WHERE CD_PEDIDO=?");
		stmt.setInt(1, ped.getCodigo());
		return stmt.executeUpdate();

	}

	public List<Pedido>mostrarPedido(int codigo)throws Exception{
		
		List<Pedido>lista=new ArrayList<Pedido>();
		stmt=con.prepareStatement("SELECT * FROM T_STB_PEDIDO INNER JOIN T_STB_PAGAMENTO \r\n" + 
				"ON (T_STB_PEDIDO.CD_PAGAMENTO = T_STB_PAGAMENTO.CD_PAGAMENTO)"+
				"INNER JOIN T_STB_ALUNO"+
				"ON (T_STB_PEDIDO.CD_ALUNO = T_STB_ALUNO.CD_ALUNO"+
				"WHERE CD_PEDIDO =?");
		
		stmt.setInt(1, codigo);
		rs=stmt.executeQuery();
		
		while(rs.next()) {
			lista.add(new Pedido(
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
							rs.getString("DT_ANO_FORMACAO"),

			                new Pagamento(
				          	rs.getInt("CD_PAGAMENTO"), 
					        rs.getString("DS_TIPO_PAG")))));
			
		
					
		}
		
		return lista;
		
	}

}
