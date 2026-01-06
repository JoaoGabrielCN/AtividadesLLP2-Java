package pratica03_04;

public class Questao3 {
	public static void main(String[] args) {
	String simbolos = "ABCabc012$*+/ ";
		
		for (int i = 0; i < simbolos.length(); i++) {
			System.out.println( "O caractere " + simbolos.charAt(i) + " tem o valor " + (int) simbolos.charAt(i) );
		}
				
	}
}
