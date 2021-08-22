import java.util.ArrayList;
import java.util.List;

public class Curriculo {

	private String semestre;
	private List alunos = new ArrayList<Aluno>();
	private List professores = new ArrayList<Professor>();
	private List disciplinas = new ArrayList<Disciplina>();
	private List users = new ArrayList<User>();
	private List cursos = new ArrayList<Curso>();
	
	public Curriculo(String semestre, List alunos, List professores, List disciplinas, List users, List cursos) {
		this.semestre = semestre;
		this.alunos = alunos;
		this.professores = professores;
		this.disciplinas = disciplinas;
		this.users = users;
		this.cursos = cursos;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public List getAlunos() {
		return alunos;
	}

	public void setAlunos(List alunos) {
		this.alunos = alunos;
	}

	public List getProfessores() {
		return professores;
	}

	public void setProfessores(List professores) {
		this.professores = professores;
	}

	public List getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List getUsers() {
		return users;
	}

	public void setUsers(List users) {
		this.users = users;
	}

	public List getCursos() {
		return cursos;
	}

	public void setCursos(List cursos) {
		this.cursos = cursos;
	}

	public void addAluno() {
		
	}
	
	public void updateAluno(){
		
	}
	
	public void removeAluno() {
		
	}
	
	public void addProfessor() {
		
	}
	
	public void updateProfessor(){
		
	}
	
	public void removeProfessor() {
		
	}
	
	public void addDisciplina() {
		
	}
	
	public void removeDisciplina() {
		
	}
	
	public void addCurso() {
		
	}
	
	public void removeCurso() {
		
	}
	
	
}
