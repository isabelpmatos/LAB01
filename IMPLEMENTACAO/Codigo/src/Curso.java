package app;

import java.util.ArrayList;

public class Curso {
	
	private String nome;
	private int numCreditos;
	private ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public Curso() {}
	
	public Curso(String nome, int numCreditos) {
		this.nome = nome;
		this.numCreditos = numCreditos;
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
	public int retornaIndex(String nomeDisciplina) {
		int index = 0;
		while(!(nomeDisciplina.contentEquals(this.disciplinas.get(index).getNome()))) {
			index++;
		}
		return index;
	}
	public Boolean contemDisciplina(String nomeDisciplina) {
		boolean contem = false;
		
		for(int i = 0; i < this.disciplinas.size(); i++) {
			if(nomeDisciplina.equals(this.disciplinas.get(i).getNome())) {
				contem = true;
			}
		}
		
		return contem;
	}
}