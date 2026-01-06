public class Gravacao extends Biblioteca {
    protected String titulo, midia;

    public Gravacao(int numeroCopias, int numeroCatalogo, String titulo, String midia) {
        super(numeroCopias, numeroCatalogo);
        this.titulo = titulo;
        this.midia = midia;
    }

    @Override
    public String toString() {
        return super.toString() +  ", titulo: " + titulo + ", midia: " + midia;
    }

    
}
