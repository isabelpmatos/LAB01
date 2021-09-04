package app;

import java.util.ArrayList;

public class Oferta {
	private int id;
	private Disciplina disciplina;
	private Professor professor;
	private boolean temProfessor;
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	
	public Oferta(int id, Disciplina disciplina, Professor professor) {
		this.id = id;
		this.setDisciplina(disciplina);
		this.setProfessor(professor);
		this.temProfessor = true;
	}
	public Oferta(int id, Disciplina disciplina) {
		this.id = id;
		this.setDisciplina(disciplina);
		this.temProfessor = false;
	}
	public Oferta() {
		
	}
	
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
		this.temProfessor = true;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public boolean isTemProfessor() {
		return temProfessor;
	}
	public void setTemProfessor(boolean temProfessor) {
		this.temProfessor = temProfessor;
	}
	public void addAluno(Aluno aluno) {
		alunos.add(aluno);
	}
	
	public void removeAluno(Aluno aluno) {
		alunos.remove(aluno);
	}
	

}