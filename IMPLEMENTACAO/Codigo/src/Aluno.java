package app;

import java.util.ArrayList;

public class Aluno extends User {
	
	private int codigoDoAluno;
	private Curso curso;
	private int periodo;
	private ArrayList<Oferta> ofertasMatriculadas = new ArrayList<Oferta>();
	private static final int NUM_DISCIPLINAS = 4;
	private static final int MAX_OPTATIVAS = 2;
	
	public Aluno() {
		
	}
	
	public Aluno(String usuario, String senha, String nome, Curso curso, int codigoDoAluno, int periodo) {
		super(usuario, senha, nome);
		this.periodo = periodo;
		this.curso = curso;
		this.codigoDoAluno = codigoDoAluno;
	}
	
	public int getperiodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	
	public Curso getCurso() {
		return this.curso;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public int getCodigoDoAluno() {
		return codigoDoAluno;
	}

	public void setCodigoDoAluno(int codigoDoAluno) {
		this.codigoDoAluno = codigoDoAluno;
	}

	public ArrayList<Oferta> getOfertasMatriculadas() {
		return ofertasMatriculadas;
	}

	public void setOfertasMatriculadas(ArrayList<Oferta> ofertas) {
		this.ofertasMatriculadas = ofertas;
	}
	
	public void addOferta(Oferta oferta) {
		ofertasMatriculadas.add(oferta);
	}

	public void removeOferta(Oferta oferta) {
		ofertasMatriculadas.remove(oferta);
	}

	

	
}
