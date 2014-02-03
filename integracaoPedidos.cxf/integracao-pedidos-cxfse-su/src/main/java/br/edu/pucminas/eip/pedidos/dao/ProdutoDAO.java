package br.edu.pucminas.eip.pedidos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.pucminas.eip.pedidos.ConexaoBD;
import br.edu.pucminas.eip.pedidos.modelo.Produto;

public class ProdutoDAO {
	 
	public boolean checarExistenciaDeProduto(int idProduto) throws SQLException {
		boolean resposta = false;
		
		ConexaoBD conectar = new ConexaoBD();
		Statement stm = conectar.criarStatement();
		
		ResultSet rs = stm.executeQuery("SELECT * FROM Produto where IdProduto = " + idProduto);
		
		if (!rs.isClosed()) {
			resposta = true;
			rs.close();
		}
			
		stm.close();
		return resposta;
	}
	
	public Produto obterProduto(int idproduto) throws SQLException {
		Produto resposta = null;
		
		ConexaoBD conectar = new ConexaoBD();
		Statement stm = conectar.criarStatement();
		
		ResultSet rs = stm.executeQuery("SELECT * FROM Produto where IdProduto = " + idproduto);
		
		if (!rs.isClosed()) {
			resposta = new Produto();
			resposta.setIdProduto(rs.getInt("IdProduto"));
			resposta.setDiasEntrega(rs.getInt("DiasEntrega"));
			resposta.setNome(rs.getString("Nome"));
			resposta.setQuantidadeEstoque(rs.getInt("QuantidadeEstoque"));
			resposta.setValorUnitario(rs.getFloat("ValorUnitario"));
			rs.close();
		}
		
		stm.close();
		return resposta;
	}
}
