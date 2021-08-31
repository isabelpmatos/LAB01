package app;

import java.util.Scanner;

public class Aplicacao {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		Universidade universidade = new Universidade();

		//Dados de teste

		Professor p = new Professor("profe", "12345", "Pedro da Silva");
		Curso c = new Curso("Engenharia de software", 5);
		Disciplina d = new Disciplina("AED2", false, 200.00);
		Disciplina d2 = new Disciplina("Arquitetura de computadores", false, 200.00);
		Disciplina d3 = new Disciplina("Direito Civil", false, 250.00);
		Oferta o = new Oferta(d, p);
		Oferta o2 = new Oferta(d2, p);
		Oferta o3 = new Oferta(d3, p);
		Aluno a = new Aluno("luiza", "lu123", "Luiza", c, 123, 2);
		Aluno a2 = new Aluno("jp", "joao123", "João Pedro", c, 1234, 2);
		Secretario s = new Secretario("sec", "sec123", "Patricia");

		universidade.addProfessor(p);
		universidade.addAluno(a);
		universidade.addAluno(a2);
		universidade.addSecretario(s);
		universidade.addCurso(c);
		universidade.addDisciplina(d);
		universidade.addDisciplina(d2);
		universidade.addDisciplina(d3);
		c.addDisciplina(d);
		c.addDisciplina(d2);
		d.addOferta(o);
		d2.addOferta(o2);
		d3.addOferta(o3);
		d.addAluno(a);
		d2.addAluno(a2);
		d2.addAluno(a);
		p.addOferta(o);
		p.addOferta(o2);
		p.addOferta(o3);

		validarLogin(universidade, teclado);
	}

	public static void validarLogin(Universidade universidade, Scanner teclado) {
		System.out.println("\nUNIVERSIDADE X \n");
		System.out.println("Insira seu usuário: ");
		String opcao = teclado.next();
		String senha = "x";
		User user = null;

		for(User u : universidade.getUsers()) {
			if (opcao.equals(u.getUsuario())){
				user = u;
				senha = u.getSenha();
			}
		}

		System.out.println("Insira sua senha");
		opcao = teclado.next();

		if (senha.equals(opcao)) {
			if (user instanceof Secretario) {
				menuSecretario(universidade, teclado, user);
			}
			else if(user instanceof Aluno) {
				menuAluno(universidade, teclado, user);
			}
			else {
				menuProfessor(universidade, teclado, user);
			}
		}
		else {
			System.out.println ("Usuário digitado inválido!");
			teclado.nextLine();
			validarLogin(universidade, teclado);
		}
	}

	public static void menuSecretario(Universidade univ, Scanner teclado, User u) {
		System.out.println("\nBEM VINDO " + u.getNome() + "\n");
		System.out.println("1 - Cadastrar Aluno");
		System.out.println("2 - Cadastrar Professor");
		System.out.println("3 - Cadastrar Curso");
		System.out.println("4 - Cadastrar Disciplinas");
		System.out.println("5 - Remover Aluno");
		System.out.println("6 - Remover Professor");
		System.out.println("7 - Imprimir Dados");
		System.out.println("0 - Sair");
		System.out.println("Insira uma opção:");

		int opcao = teclado.nextInt();
		teclado.nextLine();
		do {
			switch (opcao) {
			case 1:
				cadastrarAluno(teclado, univ, u);
				break;
			case 2:
				cadastrarProfessor(teclado, univ, u);
				break;
			case 3:
				cadastrarCurso(teclado, univ, u);
				break;
			case 7:
				imprimirDados(teclado, univ, u);
				break;
			}
		}while(opcao != 0);
		validarLogin(univ, teclado);
	}

	private static void cadastrarCurso(Scanner teclado, Universidade univ, User u) {
		Curso c = new Curso();
		System.out.println("\nCADASTRAR CURSO:\n");

		System.out.println("Nome:");
		c.setNome(teclado.nextLine());

		System.out.println("Número de Créditos:");
		c.setNumCreditos(teclado.nextInt());
		teclado.nextLine();

		int opcao = 1;
		do {
			System.out.println("Deseja inserir uma disciplina?");
			System.out.println("1 - Sim");
			System.out.println("2 - Não");
			System.out.println("Insira uma opção:");
			opcao = teclado.nextInt();
			if (opcao == 1) {
				System.out.println("\nDisciplinas disponíveis:");
				int i = 1;
				for(Disciplina d: univ.getDisciplinas()) {
					System.out.println(i + "-" + d.getNome());
					i++;
				}
				System.out.println("Insira uma opção:");
				int op = teclado.nextInt();
				Disciplina d = univ.getDisciplinas().get(op - 1);
				c.addDisciplina(d);;
				teclado.nextLine();
			}
		}while(opcao != 2);

		univ.addCurso(c);

		System.out.println("Curso Cadastrado!\n");
		
		teclado.nextLine();
		
		System.out.println("Curso:" + c.getNome());
		int i = 1;
		System.out.println("Disciplinas: \n");
		for(Disciplina d: c.getDisciplinas()) {
			System.out.println(i + "-" + d.getNome());
			i++;
		}
		
		teclado.nextLine();
		menuSecretario(univ, teclado, u);

	}

	private static void cadastrarProfessor(Scanner teclado, Universidade univ, User u) {
		Professor p = new Professor();
		System.out.println("\nCADASTRAR PROFESSOR:\n");

		System.out.println("Nome:");
		p.setNome(teclado.nextLine());;

		System.out.println("Usuário:");
		p.setUsuario(teclado.next());
		teclado.nextLine();

		System.out.println("Senha:");
		p.setSenha(teclado.next());
		teclado.nextLine();

		System.out.println("Disciplina a ser ministrada:");
		int i = 1;
		for(Disciplina d: univ.getDisciplinas()) {
			System.out.println(i + "-" + d.getNome());
			i++;
		}
		System.out.println("Insira uma opção:");
		int opcao = teclado.nextInt();
		Disciplina d = univ.getDisciplinas().get(opcao - 1);
		Oferta o = d.getOfertas().get(0);
		p.addOferta(o);;
		teclado.nextLine();

		univ.addProfessor(p);

		System.out.println("Professor Cadastrado!");
		teclado.nextLine();
		menuSecretario(univ, teclado, u);
	}

	private static void cadastrarAluno(Scanner teclado, Universidade univ, User u) {

		Aluno a = new Aluno();
		System.out.println("\nCADASTRAR ALUNO:\n");

		System.out.println("Nome:");
		a.setNome(teclado.nextLine());

		System.out.println("Usuário:");
		a.setUsuario(teclado.next());
		teclado.nextLine();

		System.out.println("Senha:");
		a.setSenha(teclado.next());
		teclado.nextLine();

		System.out.println("Curso:");
		int i = 1;
		for(Curso c: univ.getCursos()) {
			System.out.println(i + "-" + c.getNome());
			i++;
		}
		System.out.println("Insira uma opção:");
		int opcao = teclado.nextInt();
		Curso c = univ.getCursos().get(opcao - 1);
		a.setCurso(c);;
		teclado.nextLine();

		System.out.println("Código do aluno:");
		a.setCodigoDoAluno(teclado.nextInt());
		teclado.nextLine();

		System.out.println("Período do curso:");
		a.setPeriodo(teclado.nextInt());
		teclado.nextLine();

		univ.addAluno(a);

		System.out.println("Aluno cadastrado!");
		teclado.nextLine();
		menuSecretario(univ, teclado, u);

	}

	private static void imprimirDados(Scanner teclado, Universidade univ, User u) {
		System.out.println("\nALUNOS: ");
		int i = 1;
		for(Aluno a: univ.getAlunos()) {
			System.out.println(i + "-" + a.getNome());
			i++;
		}

		System.out.println("\nPROFESSORES: ");
		i = 1;
		for(Professor p: univ.getProfessores()) {
			System.out.println(i + "-" + p.getNome());
			i++;
		}

		System.out.println("\nCURSOS: ");
		i = 1;
		for(Curso c: univ.getCursos()) {
			System.out.println(i + "-" + c.getNome());
			i++;
		}

		System.out.println("\nDISCIPLINAS: ");
		i = 1;
		for(Disciplina d: univ.getDisciplinas()) {
			System.out.println(i + "-" + d.getNome());
			i++;
		}

		teclado.nextLine();
		menuSecretario(univ, teclado, u);
	}


	public static void menuAluno(Universidade univ, Scanner teclado, User u) {
		Aluno a = (Aluno) u;

		System.out.println("\nBEM VINDO " + u.getNome() + "\n");
		System.out.println("1 - Efetuar matrícula");
		System.out.println("2 - Minhas disciplinas");
		System.out.println("3 - Informações de pagamento");
		System.out.println("0 - Sair");
		System.out.println("Insira uma opção:");

		int opcao = teclado.nextInt();
		teclado.nextLine();
		do {
			switch (opcao) {
			case 1:
				efetuarMatricula(univ, teclado, a);
				break;
			case 2:
				imprimirDisciplinas(univ, teclado, opcao, a);
				break;
			case 3:
				imprimirCustoDisciplinas(univ, teclado, a);
				break;
			}
		}while(opcao != 0);
		validarLogin(univ, teclado);
	}

	private static void imprimirCustoDisciplinas(Universidade univ, Scanner teclado, Aluno a) {
		System.out.println("\nDisciplinas matriculadas e custo individual: \n");
		double soma = 0;

		int i = 1;
		for(Oferta o: a.getOfertasMatriculadas()) {
			System.out.println(i + "-" + o.getDisciplina().getNome() + " -> Custo: R$" + o.getDisciplina().getValor());
			soma += o.getDisciplina().getValor();
			i++;
		}

		System.out.println("\nValor total: R$" + soma);

		teclado.nextLine();
		menuAluno(univ, teclado, a);

	}

	private static void imprimirDisciplinas(Universidade univ, Scanner teclado, int opcao, Aluno a) {
		System.out.println("\nDisciplinas matriculadas: ");

		int i = 1;
		for(Oferta o: a.getOfertasMatriculadas()) {
			System.out.println(i + "-" + o.getDisciplina().getNome());
			i++;
		}

		teclado.nextLine();
		menuAluno(univ, teclado, a);
	}

	private static void efetuarMatricula(Universidade univ, Scanner teclado, Aluno a) {

		System.out.println("Disciplinas disponíveis: ");

		int i = 1;
		for(Disciplina d : a.getCurso().getDisciplinas()) {
			System.out.println(i + "-" + d.getNome());
			i++;
		}

		System.out.println("\nInsira uma opção: ");

		int opcao = teclado.nextInt();
		teclado.nextLine();

		Disciplina disc = a.getCurso().getDisciplinas().get(opcao - 1);
		Oferta oferta = disc.getOfertas().get(0);

		a.addOferta(oferta);

		System.out.println("Matrícula efetuada!");
		teclado.nextLine();
		menuAluno(univ, teclado, a);
	}

	public static void menuProfessor(Universidade univ, Scanner teclado, User u) {
		Professor p = (Professor) u;

		System.out.println("\nBEM VINDO " + u.getNome() + "\n");
		System.out.println("Suas disciplinas: ");

		int i = 1;
		for(Oferta o : p.getOfertasMinistradas()) {
			System.out.println(i + "-" + o.getDisciplina().getNome());
			i++;
		}
		System.out.println("0-Sair");

		System.out.println("\nInsira uma opção: ");

		int opcao = teclado.nextInt();
		teclado.nextLine();
		if(opcao == 0) {
			validarLogin(univ, teclado);
		}
		imprimirAlunos(univ, teclado, opcao, p);
		teclado.nextLine();
	}

	public static void imprimirAlunos(Universidade univ, Scanner teclado, int opcao, Professor p) {
		int i = 1;
		Oferta oferta = p.getOfertasMinistradas().get(opcao - 1);

		System.out.println("\nAlunos cursando a disciplina: ");

		for(Aluno a: oferta.getDisciplina().getAlunos()) {
			System.out.println(i + "-" + a.getNome());
		}

		teclado.nextLine();
		menuProfessor(univ, teclado, p);
	}

}
