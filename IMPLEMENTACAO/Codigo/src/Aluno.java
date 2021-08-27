package app;

import java.util.ArrayList;

public class Aluno extends User {
	private String nome;
	private int codigoDoAluno;
	private Curso curso;
	private ArrayList<Matricula> matriculas = new ArrayList<Matricula>();
	private static final int NUM_DISCIPLINAS = 4;
	private static final int MAX_OPTATIVAS = 2;
	
	public Aluno() {
		
	}
	
	public Aluno(String usuario, String senha, String nome, Curso curso) {
		super(usuario, senha);
		this.nome = nome;
		this.curso = curso;
	}
	
	public Curso getCurso() {
		return this.curso;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getCodigoDoAluno() {
		return codigoDoAluno;
	}

	public void setCodigoDoAluno(int codigoDoAluno) {
		this.codigoDoAluno = codigoDoAluno;
	}

	public ArrayList<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(ArrayList<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	
	public void addDisciplina() {
		
	}

	public void removeDisciplina() {
		
	}

	
}
