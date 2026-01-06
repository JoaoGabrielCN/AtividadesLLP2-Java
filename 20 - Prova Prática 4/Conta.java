public class Conta {
    private int conta;
    private String nome;
    private float saldo, credito, juros;
    private char genero;

    public Conta(int conta, String nome, float saldo, float credito, float juros, char genero) {
        this.conta = conta;
        this.nome = nome;
        this.saldo = saldo;
        this.credito = credito;
        this.juros = juros;
        this.genero = genero;
    }

    public Conta(String[] texts) {
            this(Integer.parseInt(texts[0]), texts[1], Float.parseFloat(texts[2]), Float.parseFloat(texts[3]),
                    Float.parseFloat(texts[4]), texts[5].charAt(0));
        
    }

    @Override
    public String toString() {
        return conta + "," + nome + "," + saldo + "," + credito + "," + juros + "," + genero;
    }

}
