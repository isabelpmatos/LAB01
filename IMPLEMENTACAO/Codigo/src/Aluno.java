import java.util.ArrayList;
import java.util.List;

public class Aluno extends User {
	private String nome;
	private int matricula;
	private Curso curso;
	private ArrayList<Disciplina> disciplinasMatriculadas = new ArrayList<Disciplina>();
	private static final int NUM_DISCIPLINAS = 4;
	private static final int MAX_OPTATIVAS = 2;
	
	public Aluno() {
		
	}
	
	public Aluno(String usuario, String senha, String nome, int matricula, Curso curso) {
		super(usuario, senha);
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
	}
	
	public Curso getCurso() {
		return this.curso;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public void updateCurso(Curso curso) {
		this.setCurso(curso);
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void updateNome(String nome) {
		this.setNome(nome);
	}
	
	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public void updateMatricula(int matricula) {
		this.setMatricula(matricula);
	}
	
	public void addDisciplina() {
		
	}

	public void removeDisciplina() {
		
	}
}
