package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.GenericDAO;
import daoImp.LivroDAOImpl;
import model.Livro;

public class LivroController {
	
	SelectLivroFactory factory = new SelectLivroFactory();
	
	public List<Livro> buscarLivro(String tipoBusca){
		//TODO
		return null;
		
	}
	
	public String gravarLivro(Livro livro){
		try {
			Connection conn = GenericDAO.getInstance().getCon();
			LivroDAOImpl dao = new LivroDAOImpl();
			
			dao.insert(conn, livro);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Livro gravado com sucesso";
		
	}
	

}
