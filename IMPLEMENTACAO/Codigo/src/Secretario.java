
public class Secretario extends User {
	private String nome;
	
	public Secretario() {
		
	}

	public Secretario(String usuario, String senha, String nome) {
		super(usuario, senha);
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void gerarCurriculo() {
		
	}

}
