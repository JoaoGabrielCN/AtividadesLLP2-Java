package questao2_6;

public class ContaCorrente  implements Tributavel, Conta{
	private int saldo;
	public double calculaTributos() {
		return this.saldo * 0.01;
	}

	public ContaCorrente(int saldo) {
		this.saldo = saldo;
	
	}
	
	public ContaCorrente() {
		this.saldo = 0;
		
	}
	
	public void deposita(double saldo) {
		this.saldo += saldo;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void retira(double saldo) {
		this.saldo -= saldo;
	}
	
	public void atualiza(double taxaSelic) {
		this.saldo *= taxaSelic;
	}
}
