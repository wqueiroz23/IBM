package br.com.studybot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.studybot.beans.Pagamento;
import br.com.studybot.conexao.Conexao;

public class PagamentoDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	public PagamentoDAO() throws Exception {

		con = new Conexao().getConexao();
	}

	public String adicionar(Pagamento pag1) throws Exception {

		stmt = con.prepareStatement(" INSERT INTO T_STB_PAGAMENTO (CD_PAGAMENTO,DS_TIPO_PAG)" + "VALUES(?,?)");
		stmt.setInt(1, pag1.getCodigo());
		stmt.setString(2, pag1.getDescricao());

		stmt.executeUpdate();

		return "Cadastrado com sucesso";

	}

	public int excluirPagamento(Pagamento pag) throws Exception {
		stmt = con.prepareStatement("DELETE FROM T_STB_CURSO WHERE CD_PAGAMENTO=?");
		stmt.setInt(1, pag.getCodigo());
		return stmt.executeUpdate();
	}

	public List<Pagamento> mostrarPagamentos(int codigo) throws Exception {
		List<Pagamento> lista = new ArrayList<Pagamento>();

		stmt = con.prepareStatement("SELECT * FROM T_STB_PAGAMENTO WHERE CD_PAGAMENTO =?");

		stmt.setInt(1, codigo);
		rs = stmt.executeQuery();

		while (rs.next()) {
			lista.add(new Pagamento(
					rs.getInt("CD_PAGAMENTO"), 
					rs.getString("DS_TIPO_PAG")));

		}

		return lista;
	}

}
