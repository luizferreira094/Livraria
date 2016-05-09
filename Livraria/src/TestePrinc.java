import java.sql.Connection;
import java.sql.SQLException;

import dao.GenericDAO;
import daoImp.LivroDAOImpl;
import model.Livro;

public class TestePrinc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
			GenericDAO co = GenericDAO.getInstance();
			Connection conn = co.getCon();
			Livro l = new Livro();
			LivroDAOImpl dao = new LivroDAOImpl();
			
			
		System.out.println(conn.toString()); 
			
			

	}

}
