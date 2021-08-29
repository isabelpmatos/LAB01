package app;

import java.util.ArrayList;

public class Curso {
	
	private String nome;
	private int numCreditos;
	private ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public Curso(String nome, int numCreditos, ArrayList<Disciplina> disciplinas) {
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

	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public void addDisciplina(Disciplina disciplina) {
		disciplinas.add(disciplina);
	}
	
	public void removeDisciplina(Disciplina disciplina) {
		disciplinas.remove(disciplina);
	}
}