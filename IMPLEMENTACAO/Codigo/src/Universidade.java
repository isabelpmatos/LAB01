package app;

import java.util.ArrayList;

public class Universidade {

	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	private ArrayList<Professor> professores = new ArrayList<Professor>();
	private ArrayList<Secretario> secretarios = new ArrayList<Secretario>();
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Curso> cursos = new ArrayList<Curso>();
	private ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();

	public Universidade() {
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

	public Curso getCursoPorNome(String nomeCurso) {
		String aux = "";
		int i = 0;
		while(aux.length() != nomeCurso.length()) {
			aux = this.cursos.get(i).getNome();
			i++;
		}
		if(aux.length() == nomeCurso.length()) {
			return this.cursos.get(i - 1);
		}
		else {
			return new Curso();
		}
	}
	public Disciplina getDisciplinaPorNome(String nomeDisciplina) {
		String aux = "";
		int i = 0;
		while(aux.length() != nomeDisciplina.length()) {
			aux = this.disciplinas.get(i).getNome();
			i++;
		}
		if(aux.length() == nomeDisciplina.length()) {
			return this.disciplinas.get(i - 1);
		}
		else {
			return new Disciplina();
		}
	}
	public Professor getProfessorPorNome(String nomeProfessor) {
		String aux = "";
		int i = 0;
		while(!(aux.equals(nomeProfessor))) {
			aux = this.professores.get(i).getNome();
			i++;
		}
		if(aux.equals(nomeProfessor)) {
			return this.professores.get(i - 1);
		}
		else {
			return new Professor();
		}
	}
	public Aluno getAlunoPorCodigo(int codigoAluno) {
		int aux = 0;
		int i = 0;
		while(aux != codigoAluno) {
			aux = this.alunos.get(i).getCodigoDoAluno();
			i++;
		}
		if(aux == codigoAluno) {
			return this.alunos.get(i - 1);
		}
		else {
			return new Aluno();
		}
	}
	public ArrayList<Secretario> getSecretarios() {
		return secretarios;
	}

	public void setSecretarios(ArrayList<Secretario> secretarios) {
		this.secretarios = secretarios;
	}
	
	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}

	public void addAluno(Aluno aluno) {
		alunos.add(aluno);
		users.add(aluno);
	}
	
	public void removeAluno(Aluno aluno) {
		alunos.remove(aluno);
		users.remove(aluno);
	}
	
	public void addProfessor(Professor professor) {
		professores.add(professor);
		users.add(professor);
	}
	
	public void removeProfessor(Professor professor) {
		professores.remove(professor);
		users.remove(professor);
	}
	
	public void addSecretario(Secretario secretario) {
		secretarios.add(secretario);
		users.add(secretario);
	}
	
	public void removeSecretario(Secretario secretario) {
		secretarios.remove(secretario);
		users.remove(secretario);
	}
	
	public void addCurso(Curso curso) {
		cursos.add(curso);
	}
	
	public void removeCurso(Curso curso) {
		cursos.remove(curso);
	}
	
	public void addDisciplina(Disciplina d) {
		disciplinas.add(d);
	}
	
	public void removeDisciplina(Disciplina d) {
		disciplinas.remove(d);
	}

	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	
	
	
}