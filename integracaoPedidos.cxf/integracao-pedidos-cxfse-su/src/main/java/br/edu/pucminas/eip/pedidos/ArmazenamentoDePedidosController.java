package br.edu.pucminas.eip.pedidos;

import java.sql.SQLException;
import java.util.Date;

import br.edu.pucminas.eip.pedidos.dao.PedidoDAO;
import br.edu.pucminas.eip.pedidos.modelo.Pedido;

public class ArmazenamentoDePedidosController {
	
	private PedidoDAO pedidoDAO;

	public boolean armazenar(int idPedido, boolean aprovado, Date dataEntrega, float valorTotal) {
		boolean retorno = false;
		
		try {
			Pedido pedido = pedidoDAO.obterPedido(idPedido);
			
			if (pedido != null) {
				retorno = armazenarPedido(idPedido, aprovado, dataEntrega, valorTotal);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return retorno;
	}

	public boolean armazenarPedido(int idPedido, boolean aprovado, Date dataEntrega, float valorTotal) {
		boolean retorno = false;
		
		try {
			retorno = pedidoDAO.atualizarPedido(idPedido, aprovado, dataEntrega, valorTotal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}

	
	public PedidoDAO getPedidoDAO() {
		return pedidoDAO;
	}

	public void setPedidoDAO(PedidoDAO pedidoDAO) {
		this.pedidoDAO = pedidoDAO;
	}
	
}
