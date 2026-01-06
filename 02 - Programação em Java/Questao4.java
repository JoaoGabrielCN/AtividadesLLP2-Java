package pratica03_04;
import java.util.Scanner;

public class Questao4 {
	public static void main(String[] args) {
		float peso, altura;
		Scanner scanner = new Scanner(System.in);
		
        System.out.println("Insira seu peso:");
        peso = scanner.nextFloat();
        
        System.out.println("Insira sua altura:");
        altura = scanner.nextFloat();
        
		float imc = peso/(altura * altura);
		
		if(imc < 18.5) {
			System.out.println("MAGREZA");
		}else if(imc >= 18.5 && imc < 24.9) {
			System.out.println("NORMAL");
		}else if(24.9 >= imc && imc < 29.9) {
			System.out.println("SOBREPESO");
		}else {
			System.out.println("OBESO");
		}
	}
}
