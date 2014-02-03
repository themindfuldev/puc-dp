package br.edu.pucminas.eip.pedidos;

import java.util.Date;

public class RetornoProcessamentoPedido {
	private boolean aprovado;
	private Date dataDeEntrega;
	private float valorTotal;
	private String mensagemDeErro;
	
	public RetornoProcessamentoPedido() {
		super();
	}
	
	public boolean isAprovado() {
		return aprovado;
	}
	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}
	public Date getDataDeEntrega() {
		return dataDeEntrega;
	}
	public void setDataDeEntrega(Date dataDeEntrega) {
		this.dataDeEntrega = dataDeEntrega;
	}
	public float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getMensagemDeErro() {
		return mensagemDeErro;
	}

	public void setMensagemDeErro(String mensagemDeErro) {
		this.mensagemDeErro = mensagemDeErro;
	}
	
}
