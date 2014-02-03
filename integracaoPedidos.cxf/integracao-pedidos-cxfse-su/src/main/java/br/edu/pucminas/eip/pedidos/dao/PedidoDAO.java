package br.edu.pucminas.eip.pedidos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.datatype.DatatypeConfigurationException;

import br.edu.pucminas.eip.pedidos.ConexaoBD;
import br.edu.pucminas.eip.pedidos.RetornoNovoPedido;
import br.edu.pucminas.eip.pedidos.modelo.Pedido;

public class PedidoDAO {
	public RetornoNovoPedido armazenarPedido(int idProduto, int quantidade) throws SQLException {
		RetornoNovoPedido retorno = new RetornoNovoPedido();
		ConexaoBD conectar = new ConexaoBD();
		Statement stm = conectar.criarStatement();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 

		String insert = "insert into Pedido (IdPedido,QuantidadeProduto,DataPedido,IdProduto) values (NULL,"
				+ quantidade + ",'" 
				+ dateFormat.format(new Date()) + "',"
				+ idProduto + ")";

		int registrosAfetados = stm.executeUpdate(insert);
		
		if (registrosAfetados == 1) {
			ResultSet resultSet = stm.getGeneratedKeys(); 

			int idPedido = 0;
			if (resultSet != null && resultSet.next()) { 
				idPedido = resultSet.getInt(1); 
			}
			
			retorno.setIdPedido(idPedido);
			retorno.setMensagemRetorno("inserido com sucesso!");
		}
		else {
			retorno.setMensagemRetorno("O banco de dados não conseguiu armazenar o pedido.");
		}
		
		stm.close();
		return retorno;
	}
	
	public Pedido obterPedido(int idPedido) throws SQLException {
		Pedido resposta = null;
		
		ConexaoBD conectar = new ConexaoBD();

		Statement stm = conectar.criarStatement();
		
		ResultSet rs = stm.executeQuery("SELECT * FROM Pedido where IdPedido = " + idPedido);
		
		if (!rs.isClosed()) {
			resposta = new Pedido();
			resposta.setIdPedido(idPedido);
			resposta.setQuantidade(rs.getInt("QuantidadeProduto"));
			resposta.setIdProduto(rs.getInt("IdProduto"));
			resposta.setDataPedido(rs.getDate("DataPedido"));
			rs.close();
		}
		
		stm.close();
		return resposta;
	}

	public boolean atualizarPedido(int idPedido, boolean aprovado,
			Date dataEntrega, float valorTotal) throws SQLException, DatatypeConfigurationException {
		boolean retorno = false;
		
		ConexaoBD conectar = new ConexaoBD();
		Statement stm = conectar.criarStatement();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		StringBuilder update = new StringBuilder();
		
		update.append("update Pedido set ");
		update.append("DataEntregaEstimada='").append(dateFormat.format(dataEntrega)).append("',");
		update.append("ValorPedido=").append(valorTotal).append(",");
		update.append("Aprovado='").append(aprovado).append("' ");
		update.append("where IdPedido=").append(idPedido); 

		int registrosAfetados = stm.executeUpdate(update.toString());
		
		if (registrosAfetados == 1) {
			retorno = true;
		}
		
		stm.close();
		return retorno;
	}
}
