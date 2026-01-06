package questao2_6;

public class GerenciadorDeImpostoDeRenda {
	private double total;
	
	void adiciona(Tributavel...tributavels) {
		for (Tributavel tributavel : tributavels) {
			total += tributavel.calculaTributos();
		}
	}
	
	public double getTotal() {
		return total;
	}
	
}
