
public class Conta {
    private int id;
    private String nome;
    private float saldo;

    public Conta(int id, String nome, float saldo) {
        this.id = id;
        this.nome = nome;
        this.saldo = saldo;
    }

    public Conta(String[] texts){
        id = Integer.parseInt(texts[0]);
        nome = texts[1];
        saldo = Float.parseFloat(texts[2]);
    }
    
    @Override
    public String toString() {
        return "Conta: " +getId() + "," + getNome() + "," + getSaldo();
    }

    public boolean retira(int valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        } else {
            System.out.println("Saldo insuficiente");
            return false;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void deposita(int valor) {
        saldo += valor;
    }

    public float verificaSaldo() {
        return saldo;
    }

}