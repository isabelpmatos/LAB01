package app;

import java.util.ArrayList;

public class Professor extends User {
	private ArrayList<Oferta> ofertasMinistradas = new ArrayList<Oferta>();
	
	public Professor() {
		
	}
	
	public Professor(String usuario, String senha, String nome) {
		super(usuario, senha, nome);
	}

	public ArrayList<Oferta> getOfertasMinistradas() {
		return ofertasMinistradas;
	}

	public void setOfertasMinistradas(ArrayList<Oferta> ofertas) {
		this.ofertasMinistradas = ofertas;
	}
	
	public void addOferta(Oferta oferta) {
		ofertasMinistradas.add(oferta);
	}
	
	public void removeDaoferta(Oferta oferta) {
		ofertasMinistradas.remove(oferta);
	}
	
	public ArrayList<Aluno> buscarAlunos(Disciplina disciplina) {
		return disciplina.getAlunos();
	}
	
}

