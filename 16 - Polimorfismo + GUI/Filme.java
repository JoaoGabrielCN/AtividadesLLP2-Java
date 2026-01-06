import java.util.Date;

public class Filme extends Gravacao {
    public String diretor, distribuidor;
    public Date dataDeLancamento;
    
    public Filme(int numeroCopias, int numeroCatalogo, String titulo, String midia, String diretor, String distribuidor, Date dataDeLancamento) {
        
        super(numeroCopias, numeroCatalogo, titulo, midia);
        this.diretor = diretor;
        this.distribuidor = distribuidor;
        this.dataDeLancamento = dataDeLancamento;
    }

    @Override
    public String toString() {
        return super.toString() +  ", diretor: " + diretor + ", distribuidor: " + distribuidor + ", dataDeLancamento: " + dataDeLancamento;
    }

    

    
}
