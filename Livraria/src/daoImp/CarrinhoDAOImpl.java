package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.openshift.client.IUser;

import dao.CarrinhoDAO;
import model.Carrinho;
import model.Livro;

public class CarrinhoDAOImpl implements CarrinhoDAO {

	@Override
	public void adicionarItem(Connection conn,Integer idCarrinho, Livro livro) throws SQLException {
		String sql = "insert into carrinho(id_carrinho,isbn, preco_livro) values(?, ?, ?)";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, idCarrinho);
		stmt.setInt(2, livro.getISBN());
		stmt.setDouble(3, livro.getPrecovenda());
		
		
		stmt.execute();
		stmt.close();
	}

	@Override
	public void alterarItem(Connection conn, Carrinho carrinho) throws SQLException {
		String sql = "update carrinho set quantidade_livros = ? and total_compra = ? where id_carrinho = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setInt(1, carrinho.getQuantidade());
		stmt.setDouble(2, carrinho.getTotal());
		stmt.setInt(3, carrinho.getIdCarrinho());
		
		stmt.execute();
		stmt.close();
	}

	@Override
	public void removerItem(Connection conn, Livro livro) throws SQLException {
		String sql = "delete from carrinho where isbn = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setInt(1, livro.getISBN());
		
		
		stmt.execute();
		stmt.close();
		
	}
	
	public Integer buscaIdCarrinho(Connection conn) throws SQLException{
		
		String sql = "select coalesce(max(id_carrinho)+1,1) as id_carrinho from carrinho";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()){
			int id = rs.getInt("id_carrinho");
			return id;
		}
		return null;
		
	}
	
	public List<Livro> select(Connection conn, Integer idCarrinho) throws SQLException{
		String sql = "select * from livro inner join carrinho on livro.isbn = carrinho.isbn where id_carrinho = ?";
		List<Livro> livroList = new ArrayList<Livro>();
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, idCarrinho);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()){
			Livro l = new Livro();
			l.setTitulo(rs.getString("titulo"));
			l.setAutor(rs.getString("autor"));
			l.setResumo(rs.getString("resumo"));
			l.setSumario(rs.getString("sumario"));
			l.setEditora(rs.getString("editora"));
			l.setQtdpagina(rs.getInt("qtdpagina"));
			l.setFormatolivro(rs.getString("formatolivro"));
			l.setDatapublicao(rs.getDate("datapublicacao"));
			l.setISBN(rs.getInt("ISBN"));
			l.setCategoria(rs.getString("categoria"));
			l.setPrecovenda(rs.getDouble("precovenda"));
			l.setPrecocusto(rs.getBigDecimal("precocusto"));
			l.setMargelucro(rs.getBigDecimal("margelucro"));
			l.setQtdestoque(rs.getInt("qtdestoque"));	
			livroList.add(l);
		}
		rs.close();
		stmt.close();
		return livroList;
	}

}
