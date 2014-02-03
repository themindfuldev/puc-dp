package br.edu.pucminas.eip.pedidos;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import br.edu.pucminas.eip.pedidos.dao.PedidoDAO;
import br.edu.pucminas.eip.pedidos.dao.ProdutoDAO;
import br.edu.pucminas.eip.pedidos.modelo.Pedido;
import br.edu.pucminas.eip.pedidos.modelo.Produto;

public class ProcessamentoDePedidosController {
	
	private ProdutoDAO produtoDAO;
	private PedidoDAO pedidoDAO;

	public RetornoProcessamentoPedido processar(int idPedido) {
		RetornoProcessamentoPedido retorno = null;
		
		try {
			Pedido pedido = pedidoDAO.obterPedido(idPedido);
			
			if (pedido != null) {
				retorno = processarPedido(pedido);
			}
			else {
				retorno = new RetornoProcessamentoPedido();
				retorno.setAprovado(false);
				retorno.setMensagemDeErro("Pedido com id " + idPedido + " inexistente.");
			}
		} catch (SQLException e) {
			retorno = new RetornoProcessamentoPedido();
			retorno.setAprovado(false);
			retorno.setMensagemDeErro("Erro no banco de dados.");
		}
		
		return retorno;
	}

	private RetornoProcessamentoPedido processarPedido(Pedido pedido) {
		RetornoProcessamentoPedido retorno = new RetornoProcessamentoPedido();
		
		try {
			Produto produto = produtoDAO.obterProduto(pedido.getIdProduto());
			
			if (produto != null) {
				if (validarEstoque(produto, pedido.getQuantidade()) == true) {
					Date dataEstimada = obterDataEstimada(produto);
					Float valorPedido = obterValorPedido(produto, pedido.getQuantidade());
					
					retorno.setAprovado(true);
					retorno.setDataDeEntrega(dataEstimada);
					retorno.setValorTotal(valorPedido);
				} else {
					retorno.setAprovado(false);
					retorno.setMensagemDeErro("Nao existe a quantidade pedida em estoque para este produto.");
					return retorno;
				}
			} else {
				retorno.setAprovado(false);
				retorno.setMensagemDeErro("Produto com id " + pedido.getIdProduto() + " inexistente.");
				return retorno;
			}

		} catch (Exception e) {
			e.printStackTrace();
			retorno.setAprovado(false);
			retorno.setMensagemDeErro("Ocorreu um erro inesperado no processamento do pedido");
		}
		return retorno;
	}

	private Date obterDataEstimada(Produto produto) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, produto.getDiasEntrega());
		return c.getTime();
	}

	private float obterValorPedido(Produto produto, int quantidadePedido) {
		return ((int)((produto.getValorUnitario() * quantidadePedido) * 100))/100.0f;
	}

	private Boolean validarEstoque(Produto produto, int quantidadePedido) {
		return produto.getQuantidadeEstoque() >= quantidadePedido;
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
