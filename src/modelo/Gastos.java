package modelo;

import java.sql.Date;
import java.util.ArrayList;

public class Gastos {
	
	private int idGasto;
	private String descricao;
	private double valorGasto;
	private Date dtGasto;
	private EnumMeioDePagamento meioDePagamento;
	private ArrayList<Produto> produtos;
	
	
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	public int getIdGasto() {
		return idGasto;
	}
	public void setIdGasto(int idGasto) {
		this.idGasto = idGasto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValorGasto() {
		return valorGasto;
	}
	public void setValorGasto(double valorGasto) {
		this.valorGasto = valorGasto;
	}
	public Date getDtGasto() {
		return dtGasto;
	}
	public void setDtGasto(Date dtGasto) {
		this.dtGasto = dtGasto;
	}
	public EnumMeioDePagamento getMeioDePagamento() {
		return meioDePagamento;
	}
	public void setMeioDePagamento(EnumMeioDePagamento meioDePagamento) {
		this.meioDePagamento = meioDePagamento;
	}
}
