package pratica03_04;

import java.util.Iterator;
import java.util.Scanner;

public class Questao1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Insira um numero inteiro de ate 5 algarismos: ");
		int n = scanner.nextInt();
		int potencia = 10000;
		
		if (n > 99999) {
			System.out.println("Numero inválido!");
		} else {
			for (int i = 0; i < 5; i++) {
				int resto;
				resto = n % potencia;
				if (n - resto != 0) {
					System.out.print((n - resto) / potencia + "   ");
				}
				potencia = potencia / 10;
				n = resto;

				if (potencia < 1) {
					break;
				}

			}
		}

	}

}
