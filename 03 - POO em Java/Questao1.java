package pratica10_04;

import java.util.Scanner;

class Aluno {
	int matricula, grupo, subturma;
	String nome, senha;

	public Aluno() {
		matricula = grupo = subturma = 0;
		nome = senha = " ";
	}

	public Aluno(int matricula, String nome, int grupo, int subturma, String senha) {
		this.matricula = matricula;
		this.nome = nome;
		this.subturma = subturma;
		this.grupo = grupo;

		if (senha.length() >= 3 && senha.length() <= 6) {
			this.senha = senha;
		} else {
			this.senha = "----";
		}
	}
	

	String senhaCensurada() {
		String censurada = "";
		if (!senha.equals("----")) {
			for (int i = 0; i < senha.length(); i++) {
				censurada = censurada + '*';
			}
		}
		return censurada;

	}

	public String toString() {

		String string = matricula + "; " + nome + "; " + grupo + "; " + subturma + "; " + senhaCensurada();
		return string;
	}
	
	
}

public class Questao1 {
	public static void main(String[] args) {
		Aluno[] alunos = new Aluno[3];
		Scanner scanner = new Scanner(System.in);

		int matricula, grupo, subturma;
		String nome, senha;

		for (int i = 0; i < 3; i++) {
			System.out.println("Insira a matricula do aluno " + (i + 1));
			matricula = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Insira o nome do aluno " + (i + 1));
			nome = scanner.nextLine();
			System.out.println("Insira o grupo do aluno " + (i + 1));
			grupo = scanner.nextInt();
			System.out.println("Insira a subturma do aluno " + (i + 1));
			subturma = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Insira a senha do aluno " + (i + 1));
			senha = scanner.nextLine();

			alunos[i] = new Aluno(matricula, nome, grupo, subturma, senha);
		}

		for (int i = 0; i < alunos.length; i++) {
			System.out.println(alunos[i].toString());
		}

	}
}
