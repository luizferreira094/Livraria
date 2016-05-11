package controller;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.CarrinhoDAO;
import dao.GenericDAO;
import dao.LivroDAO;
import daoImp.CarrinhoDAOImpl;
import model.Carrinho;
import model.Livro;

@ManagedBean
@SessionScoped
public class CarrinhoMB implements Serializable {

	private static final long serialVersionUID = -7311335770129125786L;
	private Double valorTemp;
	private Carrinho carrinhoAtual;
	private List<Carrinho> carrinhos;
	private CarrinhoDAO carrinhoDAO;
	
	public CarrinhoMB() {
		carrinhoAtual = new Carrinho();
		carrinhos = new ArrayList<Carrinho>();
		carrinhoDAO = new CarrinhoDAOImpl();
	}
	
	public String adicionarCarrinho(Livro livro) throws ClassNotFoundException, SQLException{
		CarrinhoController control = new CarrinhoController();
		control.adicionarLivroCarrinho(livro);
		return "Livro inserido com sucesso";
	}
	
	public List<Livro> atualizarCarrinho() throws ClassNotFoundException, SQLException{
		CarrinhoController control = new CarrinhoController();
		Carrinho carrinho = new Carrinho();
		carrinho.setLista(control.montarCarrinho());
		return carrinho.getLista();
	}
	
	public void editar(Carrinho carrinho) {
		carrinhoAtual = carrinho;
	}
	
	public String removerCarrinho(Livro livro){
		try {
			Connection conn = GenericDAO.getInstance().getCon();

			carrinhoDAO.removerItem(conn, livro);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return "";
	}

//	public Double alterarQuantidade(Carrinho carrinho) {
//		CarrinhoController control = new CarrinhoController();
////		return control.calcularTotal(carrinho);
//
//	}
//	
	public Double getValorTemp() {
		return valorTemp;
	}
	public void setValorTemp(Double valorTemp) {
		this.valorTemp = valorTemp;
	}

	public List<Carrinho> getCarrinhos() {
		return carrinhos;
	}

	public void setCarrinhos(List<Carrinho> carrinhos) {
		this.carrinhos = carrinhos;
	}

	public Carrinho getCarrinhoAtual() {
		return carrinhoAtual;
	}

	public void setCarrinhoAtual(Carrinho carrinhoAtual) {
		this.carrinhoAtual = carrinhoAtual;
	}

}
