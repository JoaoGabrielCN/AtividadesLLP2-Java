public class ContaPoupanca extends Conta{
    float rendimento;

    public float calculaRendimento(){
        return getSaldo() * rendimento/100;
    }

    public ContaPoupanca(int id, String nome, float saldo, float rendimento){
        super(id, nome, saldo);
        this.rendimento = rendimento;
    }

    public float getRendimento() {
        return rendimento;
    }

    public void setRendimento(float rendimento) {
        this.rendimento = rendimento;
    }

    @Override
    public String toString() {
        return "ContaPoupanca: " + getId() + "," + getNome() + "," + getSaldo() + "," + rendimento;
    }

    public ContaPoupanca(String[] texts){
        super(texts);
        rendimento = Float.parseFloat(texts[4]);
    }
}
