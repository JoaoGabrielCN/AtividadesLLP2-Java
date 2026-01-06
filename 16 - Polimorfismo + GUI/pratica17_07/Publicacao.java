public class Publicacao extends Biblioteca {
    private String titulo, editor;

    @Override
    public String toString() {
        return super.toString() + ", titulo: " +  titulo + ", editor: " + editor;
    }

    public Publicacao(int numeroCopias, int numeroCatalogo, String titulo, String editor) {
        super(numeroCopias, numeroCatalogo);
        this.titulo = titulo;
        this.editor = editor;
    }
    
}
