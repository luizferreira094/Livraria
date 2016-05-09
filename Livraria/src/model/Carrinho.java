package model;

import java.util.List;

public class Carrinho {
	
	private List<Livro> lista;
	private double total;
	private int quantidade;
	private Integer idCarrinho;
	
	public Integer getIdCarrinho() {
		return idCarrinho;
	}
	public void setIdCarrinho(Integer idCarrinho) {
		this.idCarrinho = idCarrinho;
	}
	public List<Livro> getLista() {
		return lista;
	}
	public void setLista(List<Livro> lista) {
		this.lista = lista;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	

}
