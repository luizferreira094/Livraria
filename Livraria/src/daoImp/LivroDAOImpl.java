package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.LivroDAO;
import model.Livro;

public class LivroDAOImpl implements LivroDAO {

	@Override
	public void insert(Connection conn, Livro livro) throws SQLException {
		String sql = "insert into livro(titulo,autor,resumo,sumario,editora,qtdpagina,formatolivro,datapublicao,ISBN,categoria,precovenda,precocusto,margelucro,qtdestoque)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement stmt = conn.prepareStatement(sql);
		int i = 0;
		stmt.setString(++i, livro.getTitulo());
		stmt.setString(++i, livro.getAutor());
		stmt.setString(++i, livro.getResumo());
		stmt.setString(++i, livro.getSumario());
		stmt.setString(++i, livro.getEditora());
		stmt.setInt(++i, livro.getQtdpagina());
		stmt.setString(++i, livro.getFormatolivro());
		stmt.setDate(++i, new java.sql.Date(livro.getDatapublicao().getTime()));
		stmt.setInt(++i, livro.getISBN());
		stmt.setString(++i, livro.getCategoria());
		stmt.setDouble(++i, livro.getPrecovenda());
		stmt.setBigDecimal(++i, livro.getPrecocusto());
		stmt.setBigDecimal(++i, livro.getMargelucro());
		stmt.setInt(++i, livro.getQtdestoque());

		stmt.execute();

		stmt.close();

	}

	@Override
	public List<Livro> select(Connection conn, String sql, String busca) throws SQLException {

		List<Livro> livroList = new ArrayList<>();

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, busca);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Livro livro = new Livro();

			livro.setTitulo(rs.getString("titulo"));
			livro.setAutor(rs.getString("autor"));
			livro.setPrecovenda(rs.getDouble("precovenda"));

			livroList.add(livro);
		}

		rs.close();
		stmt.close();

		return livroList;
	}

	@Override
	public Livro details(Connection conn, String livroDetalhe) throws SQLException {

		Livro livro = new Livro();

		String sql = "select titulo, autor, precovenda, resumo," + "sumario,formatolivro,editora,qtdpagina,"
				+ "datapublicacao from livro where titulo = ?";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, livroDetalhe);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			livro.setTitulo(rs.getString("titulo"));
			livro.setAutor(rs.getString("autor"));
			livro.setPrecovenda(rs.getDouble("precovenda"));
			livro.setResumo(rs.getString("resumo"));
			livro.setSumario(rs.getString("sumario"));
			livro.setFormatolivro(rs.getString("formatolivro"));
			livro.setEditora(rs.getString("editora"));
			livro.setQtdpagina(rs.getInt("qtdpagina"));
			livro.setDatapublicao(rs.getDate("datapublicacao"));
		}

		rs.close();
		stmt.close();

		return livro;
	}

	@Override
	public boolean delete(Connection conn, Integer isbn) throws SQLException {

		String sql = "delete from livro where isbn = ? limit 1";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setInt(1, isbn);
		
		stmt.execute();
		
		stmt.close();
		
		
		return true;
	}
	
	public List<Livro> selectAdvanced(Connection conn, Livro l) throws SQLException {

		List<Livro> livroList = new ArrayList<>();

		String sql = "select * from livro where titulo = ? union select * from livro where autor = ? union select * from livro where editora = ? union select * from livro where categoria = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, l.getTitulo());
		stmt.setString(2, l.getAutor());
		stmt.setString(3, l.getEditora());
		stmt.setString(4, l.getCategoria());
		
		
		System.out.println(stmt.toString());
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Livro livro = new Livro();

			livro.setTitulo(rs.getString("titulo"));
			livro.setAutor(rs.getString("autor"));
			livro.setPrecovenda(rs.getDouble("precovenda"));

			livroList.add(livro);
		}

		rs.close();
		stmt.close();

		return livroList;
	}
	

}
