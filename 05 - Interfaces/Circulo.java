package questao1_6;
import java.math.*;
public class Circulo  implements AreaCalculavel{
	private int raio;
	public Circulo(int raio) {
		this.raio = raio;
	}
	
	@Override
	public double calculaArea() {
		// TODO Auto-generated method stub
		return raio * raio * Math.PI;
	}
}
