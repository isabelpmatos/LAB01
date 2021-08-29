  
package app;

import java.util.ArrayList;

public abstract class User {
	private String usuario;
	private String senha;
	private ArrayList<User> usuarios = new ArrayList<User>();
	
	public User() {
		
	}
	
	public User(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public void addUsers (User user) {
		usuarios.add(user);
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
	
	public void recuperarSenha(String novaSenha) {
		this.setSenha(novaSenha);
	}
	
}