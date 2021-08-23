import java.util.ArrayList;
import java.util.List;

public class Professor extends User {
	private String nome;
	private ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public Professor() {
		
	}
	
	public Professor(String usuario, String senha, String nome) {
		super(usuario, senha);
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void addDisciplina() {
		
	}
	public void removeDisciplina() {
		
	}
	public void buscarAluno(Disciplina disciplina) {
		
	}
}
