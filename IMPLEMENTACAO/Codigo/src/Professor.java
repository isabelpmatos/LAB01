package app;

import java.util.ArrayList;

public class Professor extends User {
	private String nome;
	private ArrayList<Disciplina> disciplinasMinistradas = new ArrayList<Disciplina>();
	
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
	
	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinasMinistradas;
	}

	public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
		this.disciplinasMinistradas = disciplinas;
	}
	
	public void addDisciplina(Disciplina disciplina) {
		disciplinasMinistradas.add(disciplina);
	}
	
	public void removeDisciplina(Disciplina disciplina) {
		disciplinasMinistradas.remove(disciplina);
	}
	
	public ArrayList<Aluno> buscarAlunos(Disciplina disciplina) {
				return disciplina.getAlunos();
		}
		
		
	}

