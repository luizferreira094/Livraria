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

import com.mysql.fabric.xmlrpc.base.Array;

import dao.GenericDAO;
import dao.LivroDAO;
import daoImp.LivroDAOImpl;
import model.Livro;

@ManagedBean
@SessionScoped
public class LivroMB implements Serializable {

	private static final long serialVersionUID = 51283015063856075L;
	private SelectLivroFactory factory;
	private Livro livroAtual;
	private List<Livro> livros;
	private LivroDAO livroDAO;

	public LivroMB() {
		factory = new SelectLivroFactory();
		livroAtual = new Livro();
		livros = new ArrayList<Livro>();
		livroDAO = new LivroDAOImpl();
		
		buscarLivro("");
	}

	public String buscarLivro(String tipoBusca) {
		try {
			Connection conn = GenericDAO.getInstance().getCon();
			String tipoBuscaConvertido = "%"+tipoBusca+"%";
			String sql = "select titulo, autor, precovenda from livro where titulo LIKE ?";
			livros = livroDAO.select(conn, sql, tipoBuscaConvertido);
			
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Foram encontrados "+livros.size()+" livros!", "SUCESSO"));

		} catch (SQLException | ClassNotFoundException e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro na pesquisa do livro!", "ERRO"));
			e.printStackTrace();
		}
		
		return "";
	}

	public String gravarLivro() {
		try {
			Connection conn = GenericDAO.getInstance().getCon();

			livroDAO.insert(conn, livroAtual);

			livroAtual = new Livro();
			
			buscarLivro("");

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Livro cadastrado com sucesso!", "SUCESSO"));

			return "PesquisadeLivro";
		} catch (ClassNotFoundException | SQLException e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do livro!", "ERRO"));
			e.printStackTrace();
			return "";
		}
	}

	public void editarLivro(Livro l) {
		livroAtual = l;
	}

	public void deleteLivro(Livro livro) {
		try {
			Connection conn = GenericDAO.getInstance().getCon();
			livroDAO.delete(conn, livro.getISBN());
			livroAtual = new Livro();
			buscarLivro("");

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Livro removida com sucesso!", "SUCESSO"));
		} catch (SQLException | ClassNotFoundException e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro na remoção do Livro!", "ERRO"));
		}
	}

	public void removerLivro() {
		// TODO
	}

	public Livro getLivroAtual() {
		return livroAtual;
	}

	public void setLivroAtual(Livro livroAtual) {
		this.livroAtual = livroAtual;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

}
