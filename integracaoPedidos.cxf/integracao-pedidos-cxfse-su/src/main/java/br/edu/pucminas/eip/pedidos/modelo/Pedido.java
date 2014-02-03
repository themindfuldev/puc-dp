package br.edu.pucminas.eip.pedidos.modelo;

import java.util.Date;

public class Pedido {

	private int idPedido;
	private int quantidade;
	private Date dataPedido;
	private Date dataEntregaEstimada;
	private int idProduto;
	private float valorPedido;

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Date getDataEntregaEstimada() {
		return dataEntregaEstimada;
	}

	public void setDataEntregaEstimada(Date dataEntregaEstimada) {
		this.dataEntregaEstimada = dataEntregaEstimada;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public float getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(float valorPedido) {
		this.valorPedido = valorPedido;
	}

}
