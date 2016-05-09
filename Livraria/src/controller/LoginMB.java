package controller;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean
@SessionScoped
public class LoginMB implements Serializable {
	private static final long serialVersionUID = -9155445898613815732L;
	
	private String usuario;
	private String senha;
	private boolean logado;
	
	public String logar() { 
		String pagina = "1_telaLogin?faces-redirect=true";
		
		if ("admin".equals(usuario) && "123456".equals(senha)) { 
			logado = true;
			pagina = "telaAutenticaLogin?faces-redirect=true";
		} else { 
			logado = true;
			pagina = "telaPrincipal?faces-redirect=true";
		}
		return pagina;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean isLogado() {
		return logado;
	}
	public void setLogado(boolean logado) {
		this.logado = logado;
	}
}
