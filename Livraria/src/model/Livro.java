package model;

import java.math.BigDecimal;
import java.sql.Date;

public class Livro {
	
	String titulo;
	String autor;
	String resumo;
	String sumario;
	String editora;
	int qtdpagina;
	String formatolivro;
	Date datapublicao;
	int ISBN;
	String categoria;
	double precovenda;
	double precocusto;
	double margelucro;
	int qtdestoque;
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public String getSumario() {
		return sumario;
	}
	public void setSumario(String sumario) {
		this.sumario = sumario;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public int getQtdpagina() {
		return qtdpagina;
	}
	public void setQtdpagina(int qtdpagina) {
		this.qtdpagina = qtdpagina;
	}
	public String getFormatolivro() {
		return formatolivro;
	}
	public void setFormatolivro(String formatolivro) {
		this.formatolivro = formatolivro;
	}
	public Date getDatapublicao() {
		return datapublicao;
	}
	public void setDatapublicao(Date datapublicao) {
		this.datapublicao = datapublicao;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public double getPrecovenda() {
		return precovenda;
	}
	public void setPrecovenda(double precovenda) {
		this.precovenda = precovenda;
	}
	public double getPrecocusto() {
		return precocusto;
	}
	public void setPrecocusto(double precocusto) {
		this.precocusto = precocusto;
	}
	public double getMargelucro() {
		return margelucro;
	}
	public void setMargelucro(double margelucro) {
		this.margelucro = margelucro;
	}
	public int getQtdestoque() {
		return qtdestoque;
	}
	public void setQtdestoque(int qtdestoque) {
		this.qtdestoque = qtdestoque;
	}
	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", autor=" + autor + ", resumo=" + resumo + ", sumario=" + sumario
				+ ", editora=" + editora + ", qtdpagina=" + qtdpagina + ", formatolivro=" + formatolivro
				+ ", datapublicao=" + datapublicao + ", ISBN=" + ISBN + ", categoria=" + categoria + ", precovenda="
				+ precovenda + ", precocusto=" + precocusto + ", margelucro=" + margelucro + ", qtdestoque="
				+ qtdestoque + "]";
	}
	
	

}
