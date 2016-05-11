import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.CarrinhoController;
import dao.GenericDAO;
import daoImp.LivroDAOImpl;
import model.Carrinho;
import model.Livro;

public class TestePrinc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
			List<Livro> livrolist = new ArrayList<Livro>();
			GenericDAO co = GenericDAO.getInstance();
			Connection conn = co.getCon();
			Livro l = new Livro();
			Livro l2 = new Livro();
			Livro l3 = new Livro();
			
			Carrinho c = new Carrinho();
			LivroDAOImpl dao = new LivroDAOImpl();
			CarrinhoController car = new CarrinhoController();
		
			l.setPrecovenda(100);
			l.setQuantidade(1);
			l2.setPrecovenda(100);
			l.setQuantidade(2);
			l3.setPrecovenda(155);
			l.setQuantidade(1);
			
			livrolist.add(l);
			livrolist.add(l2);
			livrolist.add(l3);
			
			c.setLista(livrolist);
			double total = 0;
			for(Livro livro : livrolist){
				total = total+car.calcularTotal(livro);
				
			}
			
			
			System.out.println(livrolist.size());
			System.out.println(total);
			
	}

}
