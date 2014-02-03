package br.edu.pucminas.eip.jms;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.DateFormatter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.camel.converter.jaxp.XmlConverter;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import br.edu.pucminas.eip.pedidos.ArmazenamentoDePedidosController;
import br.edu.pucminas.eip.pedidos.RetornoProcessamentoPedido;

public class ArmazenadorDePedidos  {
    private static final transient Log log = LogFactory.getLog(ArmazenadorDePedidos.class);
    
    private ArmazenamentoDePedidosController armazenamentoDePedidosController;

    public void armazenar(Object body) {
    	try {
    		Document root = new XmlConverter().toDOMDocument((String)body);
    		Node nodeIterator = root.getFirstChild();
			String nodeName = nodeIterator.getNodeName();
			
			if (nodeName.equalsIgnoreCase("falha")) {
    			log.info("Pedido alterado nao foi armazenado.");
    		}
			else if (nodeName.equalsIgnoreCase("sucesso")) {
				nodeIterator = nodeIterator.getFirstChild();
    			int idPedido = Integer.parseInt(nodeIterator.getTextContent());
    			
    			nodeIterator = nodeIterator.getNextSibling();
		    	boolean aprovado = Boolean.parseBoolean(nodeIterator.getTextContent());
		    	
		    	if (aprovado == true) {
		    		nodeIterator = nodeIterator.getNextSibling();
		    		Date dataEntrega = new SimpleDateFormat("dd/MM/yyyy").parse(nodeIterator.getTextContent());
		    		nodeIterator = nodeIterator.getNextSibling();
		    		float valorTotal = Float.parseFloat(nodeIterator.getTextContent());
		    		
		    		boolean sucesso = armazenamentoDePedidosController.armazenar(idPedido, true, dataEntrega, valorTotal);
		    		
		    		if (sucesso == true) {
		    			log.info("Pedido alterado com id = " + idPedido + " armazenado com sucesso.");
		    		}
		    		else {
			    		log.info("Pedido alterado com id = " + idPedido + " nao foi armazenado.");
			    	}
		    	}
		    	else {
		    		String mensagemDeErro = root.getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
		    		log.info("Pedido alterado com id = " + idPedido + " nao sera armazenado, pois houve o seguinte erro: " + mensagemDeErro);
		    	}
    		}
	    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    }

	public ArmazenamentoDePedidosController getArmazenamentoDePedidosController() {
		return armazenamentoDePedidosController;
	}

	public void setArmazenamentoDePedidosController(
			ArmazenamentoDePedidosController armazenamentoDePedidosController) {
		this.armazenamentoDePedidosController = armazenamentoDePedidosController;
	}

}
