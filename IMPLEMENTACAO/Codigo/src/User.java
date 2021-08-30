  
package app;

import java.util.ArrayList;

public abstract class User {
	private String usuario;
	private String senha;
	private String nome;
	
	public User() {
		
	}
	
	public User(String usuario, String senha, String nome) {
		this.usuario = usuario;
		this.senha = senha;
		this.nome = nome;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}