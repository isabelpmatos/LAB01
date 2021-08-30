package app;

import java.util.ArrayList;

public class Oferta {
	
	private Disciplina disciplina;
	private Professor professor;
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	
	public Oferta(Disciplina disciplina, Professor professor) {
		this.setDisciplina(disciplina);
		this.setProfessor(professor);
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
	}
	
	public void addAluno(Aluno aluno) {
		alunos.add(aluno);
	}
	
	public void removeAluno(Aluno aluno) {
		alunos.remove(aluno);
	}
	

}