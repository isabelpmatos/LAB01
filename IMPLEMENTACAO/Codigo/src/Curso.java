import java.util.ArrayList;
import java.util.List;

public class Curso {
	
	private String nome;
	private int numCreditos;
	private List disciplinas = new ArrayList<Disciplina>();
	
	public Curso(String nome, int numCreditos, List disciplinas) {
		this.nome = nome;
		this.numCreditos = numCreditos;
		this.disciplinas = disciplinas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumCreditos() {
		return numCreditos;
	}

	public void setNumCreditos(int numCreditos) {
		this.numCreditos = numCreditos;
	}

	public List getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List disciplinas) {
		this.disciplinas = disciplinas;
	}

	public void addDisciplina() {
		
	}
	
	public void removeDisciplina() {
		
	}
}
