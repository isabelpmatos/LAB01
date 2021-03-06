package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
	public void transfArrayListParaAlunos(String path, Universidade universidade) {
		String line = "";
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
				PrintWriter pw = new PrintWriter(path);
				pw.close();				
				
				for(Aluno a: universidade.getAlunos()) {
					String linha = a.getUsuario().concat(",").concat(a.getSenha()).concat(",").concat(a.getNome()).concat(",").concat(a.getCurso().getNome()).concat(",").concat(Integer.toString(a.getCodigoDoAluno())).concat(",").concat(Integer.toString(a.getperiodo()));
					line = br.readLine();
					try(BufferedReader brAux = new BufferedReader(new FileReader(path))){
						try(BufferedWriter bwAux = new BufferedWriter(new FileWriter(path, true))){
							if(brAux.readLine() == null) {
								bwAux.write(linha);
							}
							else {
								bwAux.newLine();
								bwAux.write(linha);
							}
						}
						
						catch(IOException e) {
							System.out.println(e.getMessage());
						}
					}
				}
				}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void transfArrayListParaUsers(String path, Universidade universidade) {
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			PrintWriter pw = new PrintWriter(path);
			pw.close();
			
			for(User u: universidade.getUsers()) {
				String linha = u.getUsuario().concat(",").concat(u.getSenha());
				try(BufferedReader brAux = new BufferedReader(new FileReader(path))){
					try(BufferedWriter bwAux = new BufferedWriter(new FileWriter(path, true))){
						if(brAux.readLine() == null) {
							bwAux.write(linha);
						}
						else {
							bwAux.newLine();
							bwAux.write(linha);
						}
					}
				}
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public void transfArrayListParaProfessores(String path, Universidade universidade) {
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			PrintWriter pw = new PrintWriter(path);
			pw.close();
			
			for(Professor p: universidade.getProfessores()) {
				String linha = p.getUsuario().concat(",").concat(p.getSenha()).concat(",").concat(p.getNome()).concat(",");
				int i = 0;
				while(i < p.getOfertasMinistradas().size()) {
					linha = linha.concat(Integer.toString(p.getOfertasMinistradas().get(i).getId())).concat(";");
					i++;
				}
				try(BufferedReader brAux = new BufferedReader(new FileReader(path))){
					try(BufferedWriter bwAux = new BufferedWriter(new FileWriter(path, true))){
						if(brAux.readLine() == null) {
							bwAux.write(linha);
						}
						else {
							bwAux.newLine();
							bwAux.write(linha);
						}
					}
				}
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public void transfArrayListParaSecretarios(String path, Universidade universidade) {
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			PrintWriter pw = new PrintWriter(path);
			pw.close();
			for(Secretario s: universidade.getSecretarios()) {
				String linha = s.getUsuario().concat(",").concat(s.getSenha()).concat(",").concat(s.getNome());
				try(BufferedReader brAux = new BufferedReader(new FileReader(path))){
					try(BufferedWriter bwAux = new BufferedWriter(new FileWriter(path, true))){
						if(brAux.readLine() == null) {
							bwAux.write(linha);
						}
						else {
							bwAux.newLine();
							bwAux.write(linha);
						}
					}
				}
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public void transfArrayListParaOferta(String path, Universidade universidade) {
		try {
			PrintWriter pw = new PrintWriter(path);
			pw.close();
			for(Disciplina d: universidade.getDisciplinas()){
				try(BufferedReader br = new BufferedReader(new FileReader(path))){
					for(Oferta o: d.getOfertas()) {
						String linha = Integer.toString(o.getId()).concat(",").concat(o.getDisciplina().getNome()).concat(",");
						if(o.isTemProfessor()) {
							linha = linha.concat(o.getProfessor().getNome());
						}
						try(BufferedReader brAux = new BufferedReader(new FileReader(path))){
							try(BufferedWriter bwAux = new BufferedWriter(new FileWriter(path, true))){
								if(brAux.readLine() == null) {
									bwAux.write(linha);
								}
								else {
									bwAux.newLine();
									bwAux.write(linha);
								}
							}
						}
					}
				}
				catch(IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public void transfArrayListParaDisciplinas(String path, Universidade universidade) {
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			PrintWriter pw = new PrintWriter(path);
			pw.close();
			for(Disciplina d: universidade.getDisciplinas()) {
				String linha = d.getNome().concat(",").concat(Boolean.toString(d.isOptativa())).concat(",").concat(Double.toString(d.getValor())).concat(",").concat(Boolean.toString(d.isAtiva())).concat(",");
				int i = 0;
				while(i < d.getAlunos().size()) {
					linha = linha.concat(Integer.toString(d.getAlunos().get(i).getCodigoDoAluno())).concat(";");
					i++;
				}
				linha = linha.concat(",");
				i = 0;
				while(i < d.getOfertas().size()) {
					linha = linha.concat(Integer.toString(d.getOfertas().get(i).getId())).concat(";");
					i++;
				}
				try(BufferedReader brAux = new BufferedReader(new FileReader(path))){
					try(BufferedWriter bwAux = new BufferedWriter(new FileWriter(path, true))){
						if(brAux.readLine() == null) {
							bwAux.write(linha);
						}
						else {
							bwAux.newLine();
							bwAux.write(linha);
						}
					}
				}
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public void transfArrayListParaCursos(String path, Universidade universidade) {
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			PrintWriter pw = new PrintWriter(path);
			pw.close();
			for(Curso c: universidade.getCursos()) {
				String linha = c.getNome().concat(",").concat(Integer.toString(c.getNumCreditos())).concat(",");
				int i = 0;
				while(i < c.getDisciplinas().size()) {
					linha = linha.concat(c.getDisciplinas().get(i).getNome()).concat(";");
					i++;
				}
				try(BufferedReader brAux = new BufferedReader(new FileReader(path))){
					try(BufferedWriter bwAux = new BufferedWriter(new FileWriter(path, true))){
						if(brAux.readLine() == null) {
							bwAux.write(linha);
						}
						else {
							bwAux.newLine();
							bwAux.write(linha);
						}
					}
				}
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public void escreveDisciplinaNoCurso(String nomeCurso, String path, String content, Universidade universidade) {
		String line = "";
		String[] lineArray;
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			line = br.readLine();
			
			lineArray = line.split(",");
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
				while(!(nomeCurso.equals(lineArray[0]))) {
					line = br.readLine();
					lineArray = line.split(",");
				}
				if(nomeCurso.equals(lineArray[0])) {
					PrintWriter pw = new PrintWriter(path);
					pw.close();
					for(Curso c: universidade.getCursos()) {
						
						String linha = c.getNome().concat(",").concat(Integer.toString(c.getNumCreditos()).concat(","));
						int i = 0;
						while(i < c.getDisciplinas().size()) {
							linha = linha.concat(c.getDisciplinas().get(i).getNome().concat(";"));
							i++;
						}
						try(BufferedReader brAux = new BufferedReader(new FileReader(path))){
							try(BufferedWriter bwAux = new BufferedWriter(new FileWriter(path, true))){
								if(brAux.readLine() == null) {
									bwAux.write(linha);
								}
								else {
									bwAux.newLine();
									bwAux.write(linha);
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
					
				}
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public void escreveOfertaNaDisciplina(String nomeDisciplina, String path, Universidade universidade) {
		String line = "";
		String[] lineArray;
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			line = br.readLine();
			lineArray = line.split(",");
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
				while(!(nomeDisciplina.equals(lineArray[0]))) {
					line = br.readLine();
					lineArray = line.split(",");
				}
			PrintWriter pw = new PrintWriter(path);
			pw.close();
			for(Disciplina d: universidade.getDisciplinas()) {
						
				String linha = d.getNome().concat(",").concat(Boolean.toString(d.isOptativa()).concat(",").concat(Double.toString(d.getValor())).concat(",").concat(Boolean.toString(d.isAtiva())));
				linha = linha.concat(",");
				int i = 0;
				while(i < d.getAlunos().size()) {
					linha = linha.concat(Integer.toString(d.getAlunos().get(i).getCodigoDoAluno()).concat(";"));
					i++;
				}
				linha = linha.concat(",");
				i = 0;
				while(i < d.getOfertas().size()) {
					linha = linha.concat(Integer.toString(d.getOfertas().get(i).getId()).concat(";"));
					i++;
				}
				try(BufferedReader brAux = new BufferedReader(new FileReader(path))){
					try(BufferedWriter bwAux = new BufferedWriter(new FileWriter(path, true))){
						if(brAux.readLine() == null) {
							bwAux.write(linha);
						}
						else {
							bwAux.newLine();
							bwAux.write(linha);
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
					
				
			
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public void escreveProfessorEmOferta(int id, String path, Universidade universidade, Disciplina disciplina) {
		String line = "";
		String[] lineArray;
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			line = br.readLine();
			lineArray = line.split(",");
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
			PrintWriter pw = new PrintWriter(path);
			pw.close();
			
			for(Curso c: universidade.getCursos()) {
				for(Disciplina d: c.getDisciplinas()) {
					for(Oferta o: d.getOfertas()) {
						String linha = Integer.toString(o.getId()).concat(",").concat(o.getDisciplina().getNome().concat(","));
						if(o.isTemProfessor()) {
							linha = linha.concat(o.getProfessor().getNome());
						}
						
						try(BufferedReader brAux = new BufferedReader(new FileReader(path))){
							try(BufferedWriter bwAux = new BufferedWriter(new FileWriter(path, true))){
								if(brAux.readLine() == null) {
									bwAux.write(linha);
								}
								else {
									bwAux.newLine();
									bwAux.write(linha);
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
						
				}
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
				if(lineArray.length >2) {
				String[] lineDisciplinasArray = lineArray[2].split(";");
				int i = 0;
					while(i < lineDisciplinasArray.length) {
						universidade.getCursoPorNome(lineArray[0]).addDisciplina(new Disciplina(lineDisciplinasArray[i]));
						i++;
					}
					line = br.readLine();
				}
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
					if(!(lineAlunosArray[0].isBlank())) {
						while(i < lineAlunosArray.length) {
							universidade.getDisciplinaPorNome(lineArray[0]).addAluno(universidade.getAlunoPorCodigo(Integer.parseInt(lineAlunosArray[i])));
							i++;
						}
					}
				}
				line = br.readLine();
				if(lineArray.length > 5) {
					String[] lineOfertaArray = lineArray[4].split(";");
					int i = 0;
					if(!(lineOfertaArray[0].isBlank())) {
						while(i < lineOfertaArray.length) {
							universidade.getDisciplinaPorNome(lineArray[0]).addOferta(new Oferta((Integer.parseInt(lineOfertaArray[i])), universidade.getDisciplinaPorNome(lineArray[0])));
							i++;
						}
					}
				}
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
		for(Curso c: universidade.getCursos()) {
			try(BufferedReader br = new BufferedReader(new FileReader(path))){
				line = br.readLine();
					while(line != null) {
						lineArray = line.split(",");
						if(c.contemDisciplina(lineArray[1])){
							if(lineArray.length > 2 && !(lineArray[2].isBlank())) {
								c.getDisciplinaPorNome(lineArray[1]).addOferta(new Oferta(Integer.parseInt(lineArray[0]), universidade.getDisciplinaPorNome(lineArray[1]), universidade.getProfessorPorNome(lineArray[2])));
								universidade.getDisciplinaPorNome(lineArray[1]).addOferta(new Oferta(Integer.parseInt(lineArray[0]), universidade.getDisciplinaPorNome(lineArray[1]), universidade.getProfessorPorNome(lineArray[2])));
								if(universidade.getProfessorPorNome(lineArray[2]).getOfertasMinistradas().size() == 0) {
									universidade.getProfessorPorNome(lineArray[2]).addOferta(new Oferta(Integer.parseInt(lineArray[0]), universidade.getDisciplinaPorNome(lineArray[1]), universidade.getProfessorPorNome(lineArray[2])));
								}
							}
							else {
								c.getDisciplinaPorNome(lineArray[1]).addOferta(new Oferta(Integer.parseInt(lineArray[0]), universidade.getDisciplinaPorNome(lineArray[1])));
								universidade.getDisciplinaPorNome(lineArray[1]).addOferta(new Oferta(Integer.parseInt(lineArray[0]), universidade.getDisciplinaPorNome(lineArray[1])));
							}
						}
						line = br.readLine();
					}
				
			}
			catch(IOException e) {
				System.out.println(e.getMessage());
				System.out.println(e.getLocalizedMessage());
			}
			System.out.println("FIM OFERTAS --------------------------------------------");
		}
		System.out.println("FIM CARREGANDO OFERTAS --------------------------------------------");
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
