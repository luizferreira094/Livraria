package controller;

import model.Busca;

public class SelectLivroFactory {
	
	private String selectAutor(){
		
		return "autor = ?";
	}
	
	private String selectTitulo(){
		
		return "titulo = ?";
		
	}
	private String selectEditora(){
		return "editora = ?";
		
	}
	private String selectCategoria(){
		return "categoria = ?";
		
	}
	
	public String getQuery(Busca busca){
		
		StringBuilder sb = new StringBuilder();
		sb.append("select * from livro where ");
		int i = 0;
		if(busca.getTitulo()!= null){
			i++;
			sb.append(selectTitulo());
		}
		if(busca.getCategoria()!=null){
			i++;
			sb.append(selectCategoria());
		}
		if(busca.getEditora()!=null){
			i++;
			sb.append(selectEditora());
		}
		if(busca.getAutor()!=null){
			i++;
			sb.append(selectAutor());
		}
		
		
		
		return sb.toString();
		
		
		
	}

}
