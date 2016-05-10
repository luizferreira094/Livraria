import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.GenericDAO;
import daoImp.LivroDAOImpl;
import model.Livro;

public class TestePrinc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
			List<Livro> livrolist = new ArrayList<Livro>();
			GenericDAO co = GenericDAO.getInstance();
			Connection conn = co.getCon();
			Livro l = new Livro();
			LivroDAOImpl dao = new LivroDAOImpl();
			
			l.setTitulo("asdas");
			
			livrolist = dao.selectAdvanced(conn, l);
			
			for(Livro livro : livrolist){
				System.out.println(livro.toString());
			}
	}

}
