package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.GenericDAO;
import daoImp.LivroDAOImpl;
import model.Livro;

public class LivroController {
	LivroDAOImpl dao = new LivroDAOImpl();
	Connection conn;
	
	public LivroController() {
		try {
			Connection conn = GenericDAO.getInstance().getCon();
			this.conn = conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Livro> buscarLivro(String tipoBusca, String busca){
		SelectLivroFactory factory = new SelectLivroFactory();
		List<Livro> listLivro = new ArrayList<Livro>();
		try {
			
			listLivro = dao.select(conn, factory.getQuery(tipoBusca), busca);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listLivro;
		
	}
	
	public String gravarLivro(Livro livro){	
			dao.insert(conn, livro);
		return "Livro gravado com sucesso";
		
	}
	
	public Livro detalharLivro(String nomeLivro){
		Livro livro = new Livro();
		livro = dao.details(conn, nomeLivro);
		return livro;
		
	}
	

}
