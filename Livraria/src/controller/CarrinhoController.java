package controller;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.GenericDAO;
import daoImp.CarrinhoDAOImpl;
import model.Carrinho;
import model.Livro;

public class CarrinhoController {
	Integer idCarrinho = null;
	CarrinhoDAOImpl dao = new CarrinhoDAOImpl();
	
	
	public List<Livro>montarCarrinho() throws ClassNotFoundException, SQLException{
		Connection con = GenericDAO.getInstance().getCon();
		return dao.select(con,idCarrinho);
	}
	public boolean adicionarLivroCarrinho(Livro l) throws ClassNotFoundException, SQLException{
		Connection con = GenericDAO.getInstance().getCon();
		if(idCarrinho == null){
			idCarrinho = dao.buscaIdCarrinho(con);
			dao.adicionarItem(con, idCarrinho, l);	
		return true;
	}else{
		dao.adicionarItem(con, idCarrinho, l);
		return true;
	}
		
	}
	
	public Double calcularTotal(Carrinho carrinho){
		double total = 0;
		
		for(Livro l : carrinho.getLista()){
			total = (total+l.getPrecovenda());
		}
		
		return total;
		
	}
}

