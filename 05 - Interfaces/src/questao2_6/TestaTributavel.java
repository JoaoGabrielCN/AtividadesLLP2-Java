package questao2_6;

public class TestaTributavel {
	public static void main(String[] args) {
		GerenciadorDeImpostoDeRenda gerenciador = new GerenciadorDeImpostoDeRenda();
        SeguroDeVida sv = new SeguroDeVida();


        ContaCorrente cc = new ContaCorrente();
        cc.deposita(1000);
        
        gerenciador.adiciona(sv, cc);
        System.out.println(gerenciador.getTotal());
        System.out.printf("O saldo eh: %.2f", cc.getSaldo());
	}
}
