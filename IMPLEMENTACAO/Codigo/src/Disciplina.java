package app;

import java.util.ArrayList;

public class Disciplina {

	private String nome;
	private boolean isAtiva = true;
	private boolean isOptativa;
	private static final int MAX_ALUNOS = 60;
	private static final int MIN_ALUNOS = 3;
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	private double valor;
	private ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
	
	public Disciplina() {
		
	}
	
	public Disciplina(String nome) {
		this.nome = nome;
		this.isOptativa = false;
		this.valor = 0;
	}
	
	public Disciplina(String nome, boolean isOptativa, double valor) {
		this.nome = nome;
		this.isOptativa = isOptativa;
		this.valor = valor;
	}

	public boolean isAtiva() {
		return isAtiva;
	}

	public void setAtiva(boolean isAtiva) {
		this.isAtiva = isAtiva;
	}

	public boolean isOptativa() {
		return isOptativa;
	}

	public void setOptativa(boolean isOptativa) {
		this.isOptativa = isOptativa;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static int getMaxAlunos() {
		return MAX_ALUNOS;
	}

	public static int getMinAlunos() {
		return MIN_ALUNOS;
	}

	public ArrayList<Oferta> getOfertas() {
		return ofertas;
	}

	public void setOfertas(ArrayList<Oferta> ofertas) {
		this.ofertas = ofertas;
	}

	public void addAluno(Aluno aluno) {
		alunos.add(aluno);
	}
	
	public void removeAluno(Aluno aluno) {
		alunos.remove(aluno);
	}
	
	public void addOferta(Oferta o) {
		ofertas.add(o);
	}
	
	public void removeOferta(Oferta o) {
		ofertas.remove(o);
	}
	
}