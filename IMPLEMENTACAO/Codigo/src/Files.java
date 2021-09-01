package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Files {
	
	public void leituraDeArquivo(String path, ArrayList arrayList) {
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			while(line != null) {
				arrayList.add(line);
				line = br.readLine();
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public void escreveArquivo(String path, String content) {
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
				if(br.readLine() == null) {
					bw.write(content);
				}
				else {
					bw.newLine();
					bw.write(content);
				}
			}
			
			catch(IOException e) {
				System.out.println(e.getMessage());
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public boolean contem(String path, String content) {
		boolean contem = false;
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			while(contem == false && line != null) {
				contem = line.contains(content);
				line = br.readLine();
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return contem;
	}
	public String mostrarSenha(String content) {
		String path = "C:\\Users\\Daniel\\Desktop\\Lab1\\Lab1Project\\src\\app\\users.txt";
		boolean contem = false;
		String auxLine = "aux";
		String line = "";
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			line = br.readLine();
			while(contem == false && line != null) {
				contem = line.contains(content);
				auxLine = line;
				line = br.readLine();
			}
				line = auxLine.substring(content.length() + 1);
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return line;
	}
	public void carregarCursos(Universidade universidade) {
		String path = "C:\\Users\\Daniel\\Desktop\\Lab1\\Lab1Project\\src\\app\\cursos.txt";
		String line = "";
		String[] lineArray;
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			line = br.readLine();
			while(line != null) {
				lineArray = line.split(",");
				universidade.addCurso(new Curso(lineArray[0], Integer.parseInt(lineArray[1])));
				String[] lineDisciplinasArray = lineArray[2].split(";");
				int i = 0;
				while(i < lineDisciplinasArray.length) {
					universidade.getCursoPorNome(lineArray[0]).addDisciplina(new Disciplina(lineDisciplinasArray[i]));
					i++;
				}
				line = br.readLine();
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public void carregarDisciplinas(Universidade universidade) {
		String path = "C:\\Users\\Daniel\\Desktop\\Lab1\\Lab1Project\\src\\app\\disciplinas.txt";
		String line = "";
		String[] lineArray;
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			line = br.readLine();
			
			while(line != null) {
				lineArray = line.split(",");
				universidade.addDisciplina(new Disciplina(lineArray[0], Boolean.parseBoolean(lineArray[1]), Double.parseDouble(lineArray[2])));
				
				for(int i = 0; i < universidade.getCursos().size(); i++) {
					if(universidade.getCursos().get(i).contemDisciplina(lineArray[0])) {
						int index = universidade.getCursos().get(i).retornaIndex(lineArray[0]);
						universidade.getCursos().get(i).getDisciplinas().get(index).setOptativa(Boolean.parseBoolean(lineArray[1]));
						universidade.getCursos().get(i).getDisciplinas().get(index).setValor(Double.parseDouble(lineArray[2]));
						universidade.getCursos().get(i).getDisciplinas().get(index).setAtiva(Boolean.parseBoolean(lineArray[3]));
					}
				}
	
				if(lineArray.length > 4) {
					String[] lineAlunosArray = lineArray[4].split(";");
					int i = 0;
					while(i < lineAlunosArray.length) {
						universidade.getDisciplinaPorNome(lineArray[0]).addAluno(universidade.getAlunoPorCodigo(Integer.parseInt(lineAlunosArray[i])));
						i++;
					}
				}
				line = br.readLine();
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public void carregarOfertas(Universidade universidade) {
		String path = "C:\\Users\\Daniel\\Desktop\\Lab1\\Lab1Project\\src\\app\\ofertas.txt";
		String line = "";
		String[] lineArray;
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			line = br.readLine();
			while(line != null) {
				lineArray = line.split(",");
				universidade.getDisciplinaPorNome(lineArray[1]).addOferta(new Oferta(Integer.parseInt(lineArray[0]), universidade.getDisciplinaPorNome(lineArray[1]), universidade.getProfessorPorNome(lineArray[2])));
				universidade.getProfessorPorNome(lineArray[2]).addOferta(new Oferta(Integer.parseInt(lineArray[0]), universidade.getDisciplinaPorNome(lineArray[1]), universidade.getProfessorPorNome(lineArray[2])));
				System.out.println(universidade.getProfessorPorNome(lineArray[2]).getOfertasMinistradas().get(0).getDisciplina().getNome());
				line = br.readLine();
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public void carregarAlunos(Universidade universidade) {
		String path = "C:\\Users\\Daniel\\Desktop\\Lab1\\Lab1Project\\src\\app\\alunos.txt";
		String line = "";
		String[] lineArray;
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			line = br.readLine();
			while(line != null) {
				lineArray = line.split(",");
				universidade.addAluno(new Aluno(lineArray[0], lineArray[1], lineArray[2], universidade.getCursoPorNome(lineArray[3]), Integer.parseInt(lineArray[4]), Integer.parseInt(lineArray[5])));
				line = br.readLine();
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public void carregarProfessores(Universidade universidade) {
		String path = "C:\\Users\\Daniel\\Desktop\\Lab1\\Lab1Project\\src\\app\\professores.txt";
		String line = "";
		String[] lineArray;
		Professor p = new Professor();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			line = br.readLine();
			while(line != null) {
				lineArray = line.split(",");
				universidade.addProfessor(new Professor(lineArray[0], lineArray[1], lineArray[2]));
				line = br.readLine();
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public void carregarSecretarios(Universidade universidade) {
		String path = "C:\\Users\\Daniel\\Desktop\\Lab1\\Lab1Project\\src\\app\\secretarios.txt";
		String line = "";
		String[] lineArray;
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			line = br.readLine();
			while(line != null) {
				lineArray = line.split(",");
				universidade.addSecretario(new Secretario(lineArray[0], lineArray[1], lineArray[2]));
				line = br.readLine();
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public void carregarTodosArquivos() {
		
	}
}
