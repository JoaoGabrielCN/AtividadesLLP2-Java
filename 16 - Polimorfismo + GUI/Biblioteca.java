public abstract class Biblioteca{

    protected int numeroCopias, numeroCatalogo;

    public void adquirir(){};
    public void retornar(){}
   
    public Biblioteca(int numeroCopias, int numeroCatalogo) {
        this.numeroCopias = numeroCopias;
        this.numeroCatalogo = numeroCatalogo;
    }
    
    @Override
    public String toString() {
        return "numeroCopias: " + numeroCopias + ", numeroCatalogo: " + numeroCatalogo;
    };
}