
public abstract class User {
	private String usuario;
	private String senha;
	
	public User() {
		
	}
	
	public User(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public void updateUsuario(String usuario) {
		this.setUsuario(usuario);
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void updateSenha(String senha) {
		this.setSenha(senha);
	}
	
	public void recuperarSenha() {
		
	}
	
}
