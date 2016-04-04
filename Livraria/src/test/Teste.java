package test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import controller.LivroController;
import model.Livro;

public class Teste {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Livro l = new Livro();
		LivroController control = new LivroController();
		
		l.setTitulo("Star Wars: Episode I");
		l.setAutor("George Lucas");
		l.setCategoria("Ficção");
		l.setEditora("Darkside Books");
		l.setFormatolivro("Capa Dura");
		l.setISBN(12345678);
		l.setQtdpagina(400);
		l.setResumo("A long time ago in a galaxy far far away...");
		l.setPrecovenda(50);
		l.setPrecocusto(40);
		l.setQtdestoque(100);
		
//		l = control.detalharLivro("War");
//		System.out.println(l.toString());
		
		//control.gravarLivro(l);
//		List<Livro> livros = new ArrayList<Livro>();
//			livros = control.buscarLivro("autor", "George");
//			
//			for(Livro livro : livros){
//				System.out.println(livro.toString());
//			}
		

	}

}
