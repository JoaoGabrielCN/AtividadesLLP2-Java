import java.util.ArrayList;

public class Zoologico {

	public static void main(String[] args) {
		ArrayList<Mamifero> lista = new ArrayList<>();

		lista.add(new Cachorro("Bolt"));
		lista.add(new Gato());
		lista.add(new Vaca());

		for (Mamifero mamifero : lista) {
			mamifero.emitirSom();
			mamifero.mamar();

			System.out.println();
		}
	}

}