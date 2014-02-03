package br.edu.pucminas.eip.jms;

import java.text.SimpleDateFormat;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.camel.converter.jaxp.XmlConverter;

import br.edu.pucminas.eip.pedidos.ProcessamentoDePedidosController;
import br.edu.pucminas.eip.pedidos.RetornoProcessamentoPedido;

public class ProcessadorDePedidos  {
    private static final transient Log log = LogFactory.getLog(ProcessadorDePedidos.class);
    
    private ProcessamentoDePedidosController processamentoDePedidosController;

    public Object processar(Object body) {
    	StringBuilder mensagemDeRetorno = new StringBuilder();
    	
    	try {
    		Document root = new XmlConverter().toDOMDocument((String)body);
    		Node nodeIterator = root.getFirstChild();
			String nodeName = nodeIterator.getNodeName();
			
			if (nodeName.equalsIgnoreCase("falha")) {
				mensagemDeRetorno.append("<falha/>");
    			log.info("Pedido processado com falha: " + mensagemDeRetorno.toString());
			}
			else if (nodeName.equalsIgnoreCase("sucesso")) {
				nodeIterator = nodeIterator.getFirstChild();
		    	String valorMensagem = nodeIterator.getTextContent();
		    	int idPedido = Integer.parseInt(valorMensagem);
		    	
		    	RetornoProcessamentoPedido retornoProcessamento = processamentoDePedidosController.processar(idPedido);
		    	
		    	if (retornoProcessamento != null) {
		    		mensagemDeRetorno.append("<sucesso>");
		    		mensagemDeRetorno.append("<idCorrelacao>").append(idPedido).append("</idCorrelacao>");
		    		mensagemDeRetorno.append("<aprovado>").append(retornoProcessamento.isAprovado()).append("</aprovado>");
			    	if (retornoProcessamento.isAprovado() == true) {
			    		mensagemDeRetorno.append("<dataEntrega>").append(new SimpleDateFormat("dd/MM/yyyy").format(retornoProcessamento.getDataDeEntrega())).append("</dataEntrega>");
			    		mensagemDeRetorno.append("<valorTotal>").append(retornoProcessamento.getValorTotal()).append("</valorTotal>");
			    	}
			    	else {
			    		mensagemDeRetorno.append("<mensagemDeErro>").append(retornoProcessamento.getMensagemDeErro()).append("</mensagemDeErro>");
			    	}
			    	mensagemDeRetorno.append("</sucesso>");
		    	
			    	log.info("Pedido processado com sucesso: " + mensagemDeRetorno.toString());
		    	}
		    	else {
		    		mensagemDeRetorno.append("<falha/>");
		    		log.info("Pedido processado com falha: " + mensagemDeRetorno.toString());
		    	}
    		}
	    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		mensagemDeRetorno.append("<falha/>");
    		log.info("Pedido processado com falha: " + mensagemDeRetorno.toString());
    	}
        return mensagemDeRetorno.toString();
    }

	public ProcessamentoDePedidosController getProcessamentoDePedidosController() {
		return processamentoDePedidosController;
	}

	public void setProcessamentoDePedidosController(
			ProcessamentoDePedidosController processamentoDePedidosController) {
		this.processamentoDePedidosController = processamentoDePedidosController;
	}
    
}
