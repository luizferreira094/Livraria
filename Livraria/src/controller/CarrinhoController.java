package controller;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.GenericDAO;
import daoImp.CarrinhoDAOImpl;
import model.Carrinho;
import model.Livro;

public class CarrinhoController {
	
	CarrinhoDAOImpl dao = new CarrinhoDAOImpl();
	
	
	public List<Livro>montarCarrinho() throws ClassNotFoundException, SQLException{
		Connection con = GenericDAO.getInstance().getCon();
		return dao.select(con);
	}
	public boolean adicionarLivroCarrinho(Livro l) throws ClassNotFoundException, SQLException{
		Connection con = GenericDAO.getInstance().getCon();	
		Integer idCarrinho = dao.buscaIdCarrinho(con);
			dao.adicionarItem(con, idCarrinho, l);	
		return true;

	}
	
	public Double calcularTotal(Livro livro){
		return livro.getPrecovenda()*livro.getQuantidade();
		
	}
}

