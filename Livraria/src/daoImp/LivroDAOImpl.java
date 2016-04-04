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
	public void insert(Connection conn, Livro livro) {
		String sql = "insert into livro(titulo,autor,resumo,editora,qtdpagina,formatolivro,ISBN,categoria,precovenda,precocusto,margelucro,qtdestoque) values(?,?,?,"+
				"?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			int i = 0;
			stmt.setString(++i, livro.getTitulo());
			stmt.setString(++i, livro.getAutor());
			stmt.setString(++i, livro.getResumo());
			stmt.setString(++i, livro.getSumario());
			stmt.setString(++i, livro.getEditora());
			stmt.setInt(++i, livro.getQtdpagina());
			stmt.setString(++i, livro.getFormatolivro());
			stmt.setDate(++i, livro.getDatapublicao());
			stmt.setInt(++i, livro.getISBN());
			stmt.setString(++i, livro.getCategoria());
			stmt.setBigDecimal(++i, livro.getPrecovenda());
			stmt.setBigDecimal(++i, livro.getPrecocusto());
			stmt.setBigDecimal(++i, livro.getMargelucro());
			stmt.setInt(++i, livro.getQtdestoque());
			
			stmt.execute();
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public List<Livro> select(Connection conn, String sql, String busca) throws SQLException {
		
		List<Livro> livroList = new ArrayList<>();
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, busca);
	
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()){
			Livro livro = new Livro();
			
			livro.setTitulo(rs.getString("titulo"));
			livro.setAutor(rs.getString("autor"));
			livro.setPrecovenda(rs.getBigDecimal("precovenda"));
			
			livroList.add(livro);
		}
		
		rs.close();
		stmt.close();
		
		return livroList;
	}

	@Override
	public Livro details(Connection conn, String livroDetalhe) {
		
		Livro livro = new Livro();
		
		String sql = "select titulo, autor, precovenda, resumo,"
				+ "sumario,formatolivro,editora,qtdpagina,"
				+ "datapublicacao from livro where titulo = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, livroDetalhe);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livro.setPrecovenda(rs.getBigDecimal("precovenda"));
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
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	
}
