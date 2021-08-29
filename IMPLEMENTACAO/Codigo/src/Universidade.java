package app;

import java.util.ArrayList;

public class Universidade {

	private String semestre;
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	private ArrayList<Professor> professores = new ArrayList<Professor>();
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Curso> cursos = new ArrayList<Curso>();
	
	public Universidade(String semestre, ArrayList<Aluno> alunos, ArrayList<Professor> professores, ArrayList<User> users, ArrayList<Curso> cursos) {
		this.semestre = semestre;
		this.alunos = alunos;
		this.professores = professores;
		this.users = users;
		this.cursos = cursos;
	}

	public Universidade() {
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	public ArrayList<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(ArrayList<Professor> professores) {
		this.professores = professores;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}

	public void addAluno(Aluno aluno) {
		alunos.add(aluno);
	}
	
	
	public void removeAluno(Aluno aluno) {
		alunos.remove(aluno);
	}
	
	public void addProfessor(Professor professor) {
		professores.add(professor);
	}
	
	
	public void removeProfessor(Professor professor) {
		professores.remove(professor);
	}
	
	public void addCurso(Curso curso) {
		cursos.add(curso);
	}
	
	public void removeCurso(Curso curso) {
		cursos.remove(curso);
	}
	
	
}