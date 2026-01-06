package pratica10_04;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class QuestaoExtra {
	public static void main(String[] args)  throws FileNotFoundException {
		File arq = new File("pratica10_04\\pessoal.csv");
		Scanner scanner = new Scanner(arq);
		
		ArrayList<AlunoCSV> alunos = new ArrayList<AlunoCSV>();;
		scanner.nextLine();
		while (scanner.hasNextLine()) {
			String linha = scanner.nextLine();
			String [] palavras = linha.split(";", -1);
			AlunoCSV aluno = new AlunoCSV(palavras);
			
			alunos.add(aluno);
			}
		
		for (AlunoCSV alunoCSV : alunos) {
			System.out.println(alunoCSV.toString());
		}
		
		
		
	}
}

class AlunoCSV {
	String matricula, nome, email, senha, cargo, turma, setor;
	
	public AlunoCSV(String[] linha) {
		matricula = linha[0];
		nome = linha[1];
		email = linha[2];
		senha = linha[3];
		cargo = linha[4];
		turma = linha[5];
		setor = linha[6];
	}
	
	public String toString() {

		String string = matricula + "| " + nome + "| " + email + "| " + senha + "| " + cargo  + "| " + turma + "| " + setor;
		return string;
	}	
}
