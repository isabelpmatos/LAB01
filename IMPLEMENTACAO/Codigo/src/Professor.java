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
	
	public Oferta getOfertaPorId(int id) {
		int aux = 0;
		int i = 0;
		while(aux != id) {
			aux = this.getOfertasMinistradas().get(i).getId();
			i++;
		}
		if(aux == id) {
			return this.getOfertasMinistradas().get(i - 1);
		}
		else {
			return new Oferta();
		}
	}
	
}

