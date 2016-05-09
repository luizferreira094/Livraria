package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.Livro;

public interface LivroDAO {
	
	public void insert(Connection conn, Livro livro) throws SQLException;
	public Livro details(Connection conn, String nome) throws SQLException;
	public List<Livro> select(Connection conn, String sql, String busca) throws SQLException;
	public boolean delete(Connection conn, Integer isbn) throws SQLException;

}
