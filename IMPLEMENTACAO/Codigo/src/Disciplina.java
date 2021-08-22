import java.util.ArrayList;
import java.util.List;

public class Disciplina {

	private boolean isAtiva = true;
	private boolean isOptativa;
	private static final int MAX_ALUNOS = 60;
	private static final int MIN_ALUNOS = 3;
	private List alunos = new ArrayList<Aluno>();
	private double valor;
	
	public Disciplina(boolean isOptativa, List alunos, double valor) {
		this.isOptativa = isOptativa;
		this.alunos = alunos;
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

	public List getAlunos() {
		return alunos;
	}

	public void setAlunos(List alunos) {
		this.alunos = alunos;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public static int getMaxAlunos() {
		return MAX_ALUNOS;
	}

	public static int getMinAlunos() {
		return MIN_ALUNOS;
	}

	public void addAluno() {
		
	}
	
	public void removeAluno() {
		
	}
}
