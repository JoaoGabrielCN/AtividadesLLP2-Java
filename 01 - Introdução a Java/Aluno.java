import java.util.Scanner;

public class Aluno {

	public String nome;
	public int idade;
	public String identidade;

	void defineIdentidade(String valor) {
		if (valor.length() > 5) {
			identidade = valor;
		} else {
			System.out.println("A identidade deve ter ao menos 5 caracteres");
		}
	}

	String pegaIdentidade() {
		return identidade;
	}

public static void main(String[] args) {
	Aluno aluno1 = new Aluno();
	Scanner entrada = new Scanner(System.in);
	String aux = " ";
	
	System.out.println("Entre com o nome do aluno: ");
	aluno1.nome = entrada.nextLine();
	
	System.out.println("Entre com a idade do aluno: ");
	aluno1.idade = entrada.nextInt();
	
	System.out.println("Entre com a identidade (mais de 5 caracteres).");
	entrada.nextLine();
	aux = entrada.nextLine();
	aluno1.defineIdentidade(aux);
	
	System.out.println("O aluno 1, de nome " + aluno1.nome + " tem idade " + aluno1.idade);
	System.out.println("Identidade " + aluno1.pegaIdentidade());
	
	
	
	Aluno aluno2 = new Aluno();
	
	System.out.println("\nEntre com o nome do aluno: ");
	aluno2.nome = entrada.nextLine();
	
	System.out.println("Entre com a idade do aluno: ");
	aluno2.idade = entrada.nextInt();
	
	System.out.println("Entre com a identidade (mais de 5 caracteres).");
	entrada.nextLine();
	aux = entrada.nextLine();
	aluno2.defineIdentidade(aux);
	
	System.out.println("O aluno 2, de nome " + aluno1.nome + " tem idade " + aluno1.idade);
	System.out.println("Identidade " + aluno1.pegaIdentidade());
	
	
	
	
	}
}
