public class naoParException extends Exception {
    int valor;

    public naoParException(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "O numero " + valor + " nao eh par!";
    }

}