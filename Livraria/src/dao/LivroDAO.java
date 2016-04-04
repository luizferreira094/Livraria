package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.Livro;

public interface LivroDAO {
	
	public void insert(Connection conn, Livro livro);
	public Livro details(Connection conn, String nome);
	public List<Livro> select(Connection conn, String sql, String busca) throws SQLException;

}
