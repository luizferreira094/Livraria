package dao;

import java.sql.Connection;
import java.sql.SQLException;

import model.Carrinho;
import model.Livro;

public interface CarrinhoDAO {
	
	public void adicionarItem(Connection conn,Integer idCarrinho, Livro livro) throws SQLException;
	public void alterarItem(Connection conn, Carrinho carrinho) throws SQLException;
	public void removerItem(Connection conn, Livro livro) throws SQLException;

}
