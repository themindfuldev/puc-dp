package br.edu.pucminas.eip.integracao;

import javax.jms.JMSException;
import javax.jws.WebService;

import org.tempuri.ProcessarPedidoSoap;
import org.tempuri.Retorno;

import br.edu.pucminas.eip.jms.FilaJMSController;
import br.edu.pucminas.eip.pedidos.PedidosRecebidosController;
import br.edu.pucminas.eip.pedidos.RetornoNovoPedido;

@WebService(serviceName = "ProcessarPedidoService", targetNamespace = "http://tempuri.org/", name = "org.tempuri.ProcessarPedidoSoap")
public class ProcessarPedidoImpl implements ProcessarPedidoSoap {
	
	private PedidosRecebidosController pedidosRecebidosController;
	private FilaJMSController filaJMSController;
	
	@Override
	public Retorno registrarVenda(int idProduto, int quantidade) {
		RetornoNovoPedido retornoNovoPedido = pedidosRecebidosController.adicionarPedido(idProduto, quantidade);

		Retorno retorno = new Retorno();
		retorno.setIdPedido(retornoNovoPedido.getIdPedido());
		retorno.setMensagemRetorno(retornoNovoPedido.getMensagemRetorno());
		
		// Se armazenou pedido no banco, envia para fila JMS de novos pedidos 
		if (retorno.getIdPedido() > 0) {
			try {
				filaJMSController.inserirPedidoNaFila(retorno.getIdPedido());
			} catch (JMSException e) {
				e.printStackTrace();
				retorno.setIdPedido(retorno.getIdPedido());
				retorno.setMensagemRetorno("nao foi inserido na fila de mensagens para seu processamento.");
			}
		}
		return retorno;
	}

	public PedidosRecebidosController getPedidosRecebidosController() {
		return pedidosRecebidosController;
	}

	public void setPedidosRecebidosController(
			PedidosRecebidosController pedidosRecebidosController) {
		this.pedidosRecebidosController = pedidosRecebidosController;
	}

	public FilaJMSController getFilaJMSController() {
		return filaJMSController;
	}

	public void setFilaJMSController(FilaJMSController filaJMSController) {
		this.filaJMSController = filaJMSController;
	}
	
}
