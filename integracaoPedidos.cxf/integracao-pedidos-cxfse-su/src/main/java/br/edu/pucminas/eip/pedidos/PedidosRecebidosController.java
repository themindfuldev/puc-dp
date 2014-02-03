package br.edu.pucminas.eip.pedidos;

import br.edu.pucminas.eip.pedidos.dao.PedidoDAO;
import br.edu.pucminas.eip.pedidos.dao.ProdutoDAO;

public class PedidosRecebidosController {
	
	private ProdutoDAO produtoDAO;
	private PedidoDAO pedidoDAO;
	
	public RetornoNovoPedido adicionarPedido(int idProduto, int quantidade) {
		RetornoNovoPedido retorno = null;
		try {
			if (produtoDAO.checarExistenciaDeProduto(idProduto) == true) {
				retorno = pedidoDAO.armazenarPedido(idProduto, quantidade);
			} else {
				retorno = new RetornoNovoPedido();
				retorno.setMensagemRetorno("Nao existe o produto com id = " + idProduto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new RetornoNovoPedido();
			retorno.setMensagemRetorno("Ocorreu um erro de banco de dados no armazenamento do pedido.");
		}
		
		return retorno;
	}

	public ProdutoDAO getProdutoDAO() {
		return produtoDAO;
	}

	public void setProdutoDAO(ProdutoDAO produtoDAO) {
		this.produtoDAO = produtoDAO;
	}

	public PedidoDAO getPedidoDAO() {
		return pedidoDAO;
	}

	public void setPedidoDAO(PedidoDAO pedidoDAO) {
		this.pedidoDAO = pedidoDAO;
	}
	
}
