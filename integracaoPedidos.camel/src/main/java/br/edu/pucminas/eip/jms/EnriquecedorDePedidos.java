package br.edu.pucminas.eip.jms;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EnriquecedorDePedidos {
    private static final transient Log log = LogFactory.getLog(EnriquecedorDePedidos.class);

    public Object enriquecer(Object body) {
    	StringBuilder mensagemRetorno = new StringBuilder(); 
    	
    	if (body instanceof Integer) {
    		mensagemRetorno.append("<sucesso>");
	    	mensagemRetorno.append("<idPedido>").append(body.toString()).append("</idPedido>");
	    	mensagemRetorno.append("</sucesso>");
	    	log.info("Pedido enriquecido com sucesso: " + mensagemRetorno.toString());
    	}
    	else {
    		mensagemRetorno.append("<falha/>");
	    	log.info("Pedido nao foi enriquecido com sucesso. O conteudo da mensagem nao era o id do pedido como Integer.");
    	}
        return mensagemRetorno.toString();
    }

}
