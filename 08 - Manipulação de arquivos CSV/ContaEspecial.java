public class ContaEspecial extends Conta {
    float limite;

    @Override
    public boolean retira(int valor) {
        if (valor <=  getSaldo() + limite) {
            setSaldo(getSaldo() - valor);
            return true;
        } else {
            System.out.println("Saldo insuficiente");
            return false;
        }
    }

    @Override
    public float verificaSaldo() {
        return getSaldo() + limite;
    }

    public ContaEspecial(int id, String nome, float saldo, float limite) {
        super(id, nome, saldo);
        this.limite = limite;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    @Override
    public String toString() {
        return "ContaEspecial: " + getId() + "," + getNome() + "," + getSaldo() + "," + limite;
    }

    
    public ContaEspecial(String[] texts){
        super(texts);
        limite = Float.parseFloat(texts[3]);
    }

}