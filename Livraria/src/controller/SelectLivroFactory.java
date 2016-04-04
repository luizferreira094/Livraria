package controller;

public class SelectLivroFactory {
	
	private String selectAutor(){
		
		return "select titulo, autor, precovenda from livro where autor like ?";
	}
	
	private String selectTitulo(){
		
		return "select titulo, autor, precovenda from livro where titulo = ?";
		
	}
	private String selectEditora(){
		return "select titulo, autor, precovenda from livro where editora = ?";
		
	}
	private String selectCategoria(){
		return "select titulo, autor, precovenda from livro where categoria = ?";
		
	}
	
	public String getQuery(String tipoPesquisa){
		
		if(tipoPesquisa.equals("autor")){
			return selectAutor();
		}else if(tipoPesquisa.equals("titulo")){
			return selectTitulo();
		}else if(tipoPesquisa.equals("editora")){
			return selectEditora();
		}else if(tipoPesquisa.equals("categoria")){
			return selectCategoria();
		}else
			return "Tipo de Busca Invalida";
		
	}

}
